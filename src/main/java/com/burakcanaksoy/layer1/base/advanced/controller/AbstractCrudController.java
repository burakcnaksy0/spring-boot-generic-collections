package com.burakcanaksoy.layer1.base.advanced.controller;

import com.burakcanaksoy.layer1.base.advanced.service.CrudService;
import com.burakcanaksoy.layer1.user.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractCrudController<Request, Response, ID>
        implements CrudController<Request, Response, ID> {
    protected final CrudService<Request, Response, ID> service;

    protected AbstractCrudController(CrudService<Request, Response, ID> service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ApiResponse<Response>> getById(@PathVariable("id") ID id) {
        ApiResponse<Response> response = ApiResponse.success("Başarıyla bulundu: " + id, service.getById(id), HttpStatus.OK);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @GetMapping
    @Override
    public ResponseEntity<ApiResponse<List<Response>>> getAll() {
        ApiResponse<List<Response>> response = ApiResponse.success("Başarıyla listelendi", service.getAll(), HttpStatus.OK);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @PostMapping
    @Override
    public ResponseEntity<ApiResponse<Response>> create(@Valid @RequestBody Request request) {
        ApiResponse<Response> response = ApiResponse.success(
                "Başarıyla oluşturuldu",
                service.create(request),
                HttpStatus.CREATED);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable("id") ID id) {
        service.delete(id);
        ApiResponse<Void> response = ApiResponse.success(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
