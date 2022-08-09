package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.GreetingAppDto;
import com.bridgelabz.greetingapp.dto.GreetingUserDto;
import com.bridgelabz.greetingapp.model.GreetingAppModel;
import com.bridgelabz.greetingapp.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {
    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingAppRepository greetingAppRepository;


    @Override
    public GreetingAppModel greetingMessage() {
        return greetingAppRepository.save(new GreetingAppModel(String.format(template, "Ashwini!")));
    }

    @Override
    public GreetingAppModel greetingMessageByName(GreetingUserDto greetingUserDto) {
        return greetingAppRepository.save(new GreetingAppModel(String.format(template, greetingUserDto.getFirstName()) + " " + greetingUserDto.getLastName()));
    }

    @Override
    public Optional<GreetingAppModel> getById(long id) {
        Optional<GreetingAppModel> greetById = greetingAppRepository.findById(id);
        if (greetById.isPresent()) {
            return greetById;
        } else
            throw new RuntimeException();
    }

    @Override
    public List<GreetingAppModel> getAllGreetingMessage() {
        List<GreetingAppModel> getAllGreetingMessage = greetingAppRepository.findAll();
        if (getAllGreetingMessage.size() > 0) {
            return getAllGreetingMessage;
        } else
            throw new RuntimeException();
    }

    @Override
    public GreetingAppModel updateGreetMessage(long id, GreetingAppDto greetingAppDto) {
        Optional<GreetingAppModel> updateMessage = greetingAppRepository.findById(id);
        if (updateMessage.isPresent()) {
            updateMessage.get().setMessage(greetingAppDto.getMessage());
            greetingAppRepository.save(updateMessage.get());
            return updateMessage.get();
        } else
            throw new RuntimeException();
    }

    @Override
    public GreetingAppModel deleteMessage(long id) {
        Optional<GreetingAppModel> isIdPresent = greetingAppRepository.findById(id);
        if (isIdPresent.isPresent()) {
            greetingAppRepository.save(isIdPresent.get());
            return isIdPresent.get();
        } else {
            throw new RuntimeException();
        }
    }

}
