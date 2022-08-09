package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.GreetingAppDto;
import com.bridgelabz.greetingapp.dto.GreetingUserDto;
import com.bridgelabz.greetingapp.model.GreetingAppModel;

import java.util.List;
import java.util.Optional;


public interface IGreetingService {
    GreetingAppModel greetingMessage();

    GreetingAppModel greetingMessageByName(GreetingUserDto greetingUserDto);

    Optional<GreetingAppModel> getById(long id);

    List<GreetingAppModel> getAllGreetingMessage();

    GreetingAppModel updateGreetMessage(long id, GreetingAppDto greetingAppDto);

    GreetingAppModel deleteMessage(long id);
}
