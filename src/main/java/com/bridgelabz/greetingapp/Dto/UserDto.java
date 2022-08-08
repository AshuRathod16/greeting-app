package com.bridgelabz.greetingapp.Dto;

import lombok.Data;

@Data
public class UserDto {
    private String firstName;
    private String lastName;

    public UserDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
