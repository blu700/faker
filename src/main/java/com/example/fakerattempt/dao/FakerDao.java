package com.example.fakerattempt.dao;

import com.example.fakerattempt.model.User;
import com.github.javafaker.IdNumber;

import java.util.List;

public interface FakerDao {

    List<User> getAllUsers();
    User getUserById(IdNumber id);
    void saveUser(User user);
    void deleteUser(User user);

}
