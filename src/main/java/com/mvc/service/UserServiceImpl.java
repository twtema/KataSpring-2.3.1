package com.mvc.service;

import com.mvc.model.User;
import com.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUser();
    }

    @Override
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteUser(id);
    }

    @Override
    public void editUser(Integer id, User user) {
        userRepository.editUser(id, user);
    }

    @Override
    public User getUser(Integer id) {
        return userRepository.getUser(id);
    }
}