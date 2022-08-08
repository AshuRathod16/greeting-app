package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.Dto.GreetingAppDto;
import com.bridgelabz.greetingapp.Dto.UserDto;


public interface IGreetingService {
    GreetingAppDto greetingMessage();

    GreetingAppDto greetingMessageByName(UserDto userDto);

}
