package com.email2tg.rest.userservice.controller;

import com.email2tg.rest.userservice.model.User;
import com.email2tg.rest.userservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user")
    @Operation(summary = "Создание пользователя на почтовом сервере")
    public ResponseEntity<?> create (@RequestBody User user) throws IOException {
        userService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
