package com.burakcanaksoy.layer1.user;

import com.burakcanaksoy.layer1.BaseMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserMapper implements BaseMapper<User , UserCreateRequest , UserResponse> {
    @Override
    public User mapToEntity(UserCreateRequest request) {
        if (request == null){
            return null;
        }
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .email(request.getEmail())
                .phone(request.getPhone())
                .age(request.getAge())
                .active(true)
                .build();
    }

    @Override
    public UserResponse mapToResponse(User entity) {
        if (entity == null){
            return null;
        }
        return UserResponse.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .age(entity.getAge())
                .active(entity.isActive())
                .build();
    }
}
