package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.GreetingAppDto;
import com.bridgelabz.greetingapp.dto.GreetingUserDto;
import com.bridgelabz.greetingapp.model.GreetingAppModel;
import com.bridgelabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private static final String template = "Hello %s!!";
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
    public GreetingAppModel greeting() {
        return greetingService.greetingMessage();
    }

    //UC3
    @PostMapping("/post/greeting")
    private GreetingAppModel greeting(@RequestBody GreetingUserDto greetingUserDTO) {
        return greetingService.greetingMessageByName(greetingUserDTO);
    }

    //UC5
    @GetMapping("/find")
    public Optional<GreetingAppModel> greetById(@PathVariable long id) {
        return greetingService.getById(id);
    }

    //UC6
    @GetMapping("/allgreeting")
    public List<GreetingAppModel> allGreetingMessage() {
        return greetingService.getAllGreetingMessage();
    }

    //UC7
    @PutMapping("/editmessage/{id}")
    public GreetingAppModel editGreetMessage(@PathVariable long id, @RequestParam GreetingAppDto greetingAppDto) {
        return greetingService.updateGreetMessage(id, greetingAppDto);
    }

    @DeleteMapping("/deletemessage/{id}")
    public GreetingAppModel deleteMessage(@PathVariable long id) {
        return greetingService.deleteMessage(id);
    }
}
