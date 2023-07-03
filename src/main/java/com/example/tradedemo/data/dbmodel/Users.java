package com.example.tradedemo.data.dbmodel;

import com.example.tradedemo.data.enums.UserType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    private UUID id;
    private String userName;
    private String userLastName;
    private ZonedDateTime createdDate;
    private UserType userType;

}
