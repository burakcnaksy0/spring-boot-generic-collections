package com.burakcanaksoy.layer1.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUsers() {
        ApiResponse<List<UserResponse>> response = ApiResponse.success(
                "Kullanıcılar başarıyla listelendi",
                userService.getAllUsers(),
                HttpStatus.OK);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable Long id) {
        ApiResponse<UserResponse> response = ApiResponse.success(
                "Kullanıcı başarıyla bulundu: " + id,
                userService.getUserById(id),
                HttpStatus.OK);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<UserResponse>> createUser(@RequestBody @Valid UserCreateRequest request) {
        ApiResponse<UserResponse> response = ApiResponse.success(
                "Kullanıcı başarıyla oluşturuldu",
                userService.createUser(request),
                HttpStatus.CREATED);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        ApiResponse<Void> response = ApiResponse.success(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
