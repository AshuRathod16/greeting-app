package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.GreetingUserDto;
import com.bridgelabz.greetingapp.model.GreetingAppModel;


public interface IGreetingService {
    GreetingAppModel greetingMessage();

    GreetingAppModel greetingMessageByName(GreetingUserDto greetingUserDto);



}
