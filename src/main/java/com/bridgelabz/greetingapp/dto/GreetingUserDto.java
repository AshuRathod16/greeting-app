package com.bridgelabz.greetingapp.dto;

import lombok.Data;

@Data
public class GreetingUserDto {
   private String firstName;
   private String lastName;

    public GreetingUserDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
