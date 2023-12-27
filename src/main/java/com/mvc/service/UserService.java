package com.mvc.service;

import com.mvc.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(Integer id);

    void deleteUser(Integer id);

    void editUser(Integer id, User user);
}

