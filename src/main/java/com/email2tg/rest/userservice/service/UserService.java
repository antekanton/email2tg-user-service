package com.email2tg.rest.userservice.service;

import com.email2tg.rest.userservice.model.User;

import java.io.IOException;

public interface UserService {
    /**
    * Создает нового пользователя
    * @param user - имя пользователя для создания
    */
    void create(User user) throws IOException;
}

