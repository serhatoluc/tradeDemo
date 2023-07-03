package com.example.tradedemo.services;

import com.example.tradedemo.data.payload.request.UserRequest;
import com.example.tradedemo.data.payload.response.UserResponse;
import com.example.tradedemo.mapper.UserMapper;
import com.example.tradedemo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public UserResponse createUser(UserRequest userRequest) {
        userRepository.save(userMapper.toUsersFromUserRequest(userRequest));
        return userMapper.toUserResponseFromUserRequest(userRequest);
    }

    public UserResponse deleteUserById(UUID userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
        }
        return null;
    }

    public List<UserResponse> getAllUsers() {
        return userMapper.toListFromEntities(userRepository.findAll());
    }
}
