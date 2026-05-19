package com.burakcanaksoy.layer1.user;

import com.burakcanaksoy.layer1.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController<UserCreateRequest, User, UserResponse, Long> {

    public UserController(UserService userService) {
        super(userService);
    }

}
