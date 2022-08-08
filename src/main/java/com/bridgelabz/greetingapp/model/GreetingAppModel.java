package com.bridgelabz.greetingapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class GreetingAppModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    String message;

    public GreetingAppModel() {
    }

    public GreetingAppModel(String message) {
        this.message = message;
    }
}
