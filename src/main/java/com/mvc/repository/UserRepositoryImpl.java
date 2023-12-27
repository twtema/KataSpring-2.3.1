package com.mvc.repository;

import com.mvc.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = entityManager.getReference(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void editUser(Integer id, User updatedUser) {
        User user = entityManager.find(User.class, id);
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setAge(updatedUser.getAge());
    }
}