package com.burakcanaksoy.layer1.user;

import com.burakcanaksoy.layer1.base.advanced.service.AbstractCrudService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends AbstractCrudService<UserCreateRequest,User,UserResponse,Long> {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository,UserMapper mapper){
        super(userRepository,mapper);
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new UserNotFoundException("User not found with this id : "+ id);
        }
        return super.getById(id);
    }

    @Override
    public void delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new UserNotFoundException("User not found with this id : "+ id);
        }
        super.delete(id);
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
