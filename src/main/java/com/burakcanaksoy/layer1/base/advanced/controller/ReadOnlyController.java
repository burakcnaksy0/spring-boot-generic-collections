package com.burakcanaksoy.layer1.base.advanced.controller;

import com.burakcanaksoy.layer1.user.ApiResponse;
import org.springframework.http.ResponseEntity;
import java.util.*;

public interface ReadOnlyController<Response, ID> {
    ResponseEntity<ApiResponse<Response>> getById(ID id);
    ResponseEntity<ApiResponse<List<Response>>> getAll();
}
