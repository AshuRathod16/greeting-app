package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.GreetingAppDto;
import com.bridgelabz.greetingapp.dto.GreetingUserDto;


public interface IGreetingService {
    GreetingAppDto greetingMessage();

    GreetingAppDto greetingMessageByName(GreetingUserDto greetingUserDto);



}
