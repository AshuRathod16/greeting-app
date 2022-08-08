package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.Dto.GreetingAppDto;
import com.bridgelabz.greetingapp.Dto.UserDto;
import com.bridgelabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    public IGreetingService greetingService;

    /*
    UC1
    Url - http://localhost:8082/greeting
    return - {"id": 1,"message": "Hello World!"}
    Url - http://localhost:8082/greeting?name=Ashwini
    return - {"id": 2, "message": "Hello Ashwini!"}
     */

    @GetMapping(value = {"/greeting", "/greeting/home"})
    public GreetingAppDto greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new GreetingAppDto(counter.incrementAndGet(), String.format(template, name));
    }

    /*
    UC2
    Url - http://localhost:8082/greeting/service
    return - {"id": 1, "message": "Hello world!"}
     */
    @GetMapping("greeting/service")
    public GreetingAppDto greeting() {
        return greetingService.greetingMessage();
    }

    @PostMapping("/greeting")
    private GreetingAppDto greetingMessage(@RequestBody UserDto userDto) {
        return greetingService.greetingMessageByName(userDto);
    }
}
