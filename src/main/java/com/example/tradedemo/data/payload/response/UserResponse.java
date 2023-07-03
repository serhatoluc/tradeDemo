package com.example.tradedemo.data.payload.response;

import com.example.tradedemo.data.enums.UserType;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Builder
public class UserResponse {

    private String userName;
    private String userLastName;
    private ZonedDateTime createdDate;
    private UserType userType;
}
