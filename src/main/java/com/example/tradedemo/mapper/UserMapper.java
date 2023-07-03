package com.example.tradedemo.mapper;

import com.example.tradedemo.data.dbmodel.Users;
import com.example.tradedemo.data.payload.request.UserRequest;
import com.example.tradedemo.data.payload.response.UserResponse;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class UserMapper {

    public UserResponse toUserResponseFromUserRequest(UserRequest user) {
        return UserResponse.builder()
                .userLastName(user.getUserLastName())
                .createdDate(ZonedDateTime.now())
                .userName(user.getUserName())
                .userType(user.getUserType())
                .build();
    }

    public Users toUsersFromUserRequest(UserRequest user) {
        return Users.builder()
                .id(UUID.randomUUID())
                .userLastName(user.getUserLastName())
                .createdDate(ZonedDateTime.now())
                .userName(user.getUserName())
                .userType(user.getUserType())
                .build();
    }

    public UserResponse toUserResponseFromUsers(Users user) {
        return UserResponse.builder()
                .userType(user.getUserType())
                .userName(user.getUserName())
                .userLastName(user.getUserLastName())
                .createdDate(user.getCreatedDate())
                .build();
    }

    public List<UserResponse> toListFromEntities(List<Users> users) {
        return users.stream()
                .map(user -> UserResponse.builder()
                        .createdDate(user.getCreatedDate())
                        .userLastName(user.getUserLastName())
                        .userName(user.getUserName())
                        .userType(user.getUserType())
                        .build())
                .toList();
    }
}
