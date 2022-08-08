package com.bridgelabz.greetingapp.repository;

import com.bridgelabz.greetingapp.model.GreetingAppModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingAppRepository extends JpaRepository<GreetingAppModel, Long> {
}
