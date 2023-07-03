package com.example.tradedemo.controller;

import com.example.tradedemo.data.payload.request.UserRequest;
import com.example.tradedemo.data.payload.response.UserResponse;
import com.example.tradedemo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/create-new-user")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @GetMapping("/get-users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/delete-user/{userId}")
    public ResponseEntity<UserResponse> deleteUserById(@PathVariable UUID userId) {
        return ResponseEntity.ok(userService.deleteUserById(userId));
    }
}
