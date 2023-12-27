package com.mvc.repository;

import com.mvc.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUser();

    void saveUser(User user);

    User getUser(Integer id);

    void deleteUser(Integer id);
     void editUser(Integer id, User updatedUser);
}
