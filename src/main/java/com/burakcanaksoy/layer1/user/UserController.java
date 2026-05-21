package com.burakcanaksoy.layer1.user;

import com.burakcanaksoy.layer1.base.advanced.controller.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController extends AbstractCrudController<UserCreateRequest,UserResponse,Long> {

    public UserController(UserService userService) {
        super(userService);
    }
}
