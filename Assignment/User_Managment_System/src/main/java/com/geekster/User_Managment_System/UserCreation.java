package com.geekster.User_Managment_System;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class UserCreation {
    @Bean
    public List<User> getTodoList(){
        return new ArrayList<>();
    }
}
