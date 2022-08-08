package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.Dto.GreetingAppDto;
import com.bridgelabz.greetingapp.Dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {
    private static final String template = "Hello world!";
    private final AtomicLong counter = new AtomicLong();


    @Override
    public GreetingAppDto greetingMessage() {
        return new GreetingAppDto(counter.incrementAndGet(), String.format(template));
    }

    @Override
    public GreetingAppDto greetingMessageByName( UserDto userDto) {
        return new GreetingAppDto(counter.incrementAndGet(),
                String.format(template, userDto.getFirstName()) + userDto.getLastName());

    }

}
