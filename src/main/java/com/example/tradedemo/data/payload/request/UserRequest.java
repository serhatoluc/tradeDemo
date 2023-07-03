package com.example.tradedemo.data.payload.request;

import com.example.tradedemo.data.enums.UserType;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Builder
public class UserRequest {

    private String userName;
    private String userLastName;
    private ZonedDateTime createdDate;
    private UserType userType;
}
