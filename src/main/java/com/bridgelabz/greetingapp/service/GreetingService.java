package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.GreetingAppDto;
import com.bridgelabz.greetingapp.dto.GreetingUserDto;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {
    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();


    @Override
    public GreetingAppDto greetingMessage() {
        return new GreetingAppDto(counter.incrementAndGet(), String.format(template));
    }

    @Override
    public GreetingAppDto greetingMessageByName(GreetingUserDto greetingUserDto) {
        return new GreetingAppDto(counter.incrementAndGet(), String.format(template, greetingUserDto.getFirstName()) + " " + greetingUserDto.getLastName());
    }

}
