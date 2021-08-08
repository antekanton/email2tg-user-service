package com.email2tg.rest.userservice.service;

import com.email2tg.rest.userservice.model.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServiceImpl implements UserService {

    //Мапа пользователей
    private static final Map<Integer, User> USER_MAP = new HashMap<>();

    private static final AtomicInteger USER_ID = new AtomicInteger();

    @Override
    public void create(User user) throws IOException {
        final int userId = USER_ID.incrementAndGet();
        user.setId(userId);
        USER_MAP.put(userId, user);
        Runtime.getRuntime().exec(String.format("sh /home/ubuntu/add_email.sh %s", user.getUsername()));
    }
}