package com.burakcanaksoy.layer1.base;

import com.burakcanaksoy.layer1.base.senior.service.AbstractCrudService;
import com.burakcanaksoy.layer1.user.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<Request, Entity, Response, ID> {
    protected final AbstractCrudService<Request, Entity, Response, ID> service;

    protected BaseController(AbstractCrudService<Request, Entity, Response, ID> service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<Response>>> getAll() {
        ApiResponse<List<Response>> response = ApiResponse.success(
                "Başarıyla listelendi",
                service.getAll(),
                HttpStatus.OK);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Response>> getById(@PathVariable ID id) {
        ApiResponse<Response> response = ApiResponse.success(
                "Başarıyla bulundu: " + id,
                service.getById(id),
                HttpStatus.OK);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<Response>> create(@RequestBody @Valid Request request) {
        ApiResponse<Response> response = ApiResponse.success(
                "Başarıyla oluşturuldu",
                service.create(request),
                HttpStatus.CREATED);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable ID id) {
        service.delete(id);
        ApiResponse<Void> response = ApiResponse.success(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
