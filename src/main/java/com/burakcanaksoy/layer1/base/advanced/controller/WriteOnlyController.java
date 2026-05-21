package com.burakcanaksoy.layer1.base.advanced.controller;

import com.burakcanaksoy.layer1.user.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface WriteOnlyController<Request , Response , ID> {
    ResponseEntity<ApiResponse<Response>> create(Request request);
    ResponseEntity<ApiResponse<Void>> delete(ID id);
}
