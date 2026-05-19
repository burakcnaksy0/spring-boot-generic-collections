package com.burakcanaksoy.layer1.user;

import com.burakcanaksoy.layer1.base.advanced.service.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractCrudService<UserCreateRequest,User,UserResponse,Long> {
    private final UserRepository userRepository;

    public UserService(UserRepository repository,UserMapper mapper){
        super(repository,mapper);
        this.userRepository = repository;
    }


    @Override
    public UserResponse create(UserCreateRequest userCreateRequest) {
        checkEmailExists(userCreateRequest.getEmail());
        checkPhoneExists(userCreateRequest.getPhone());
        return super.create(userCreateRequest);
    }

    private void checkEmailExists(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new UserAlreadyExistsException("User already exists with email : " + email);
        }
    }

    private void checkPhoneExists(String phone) {
        if (userRepository.existsByPhone(phone)) {
            throw new UserAlreadyExistsException("User already exists with phone : " + phone);
        }
    }

}
