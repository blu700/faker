package com.example.fakerattempt.dao;

import com.example.fakerattempt.model.User;
import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class FakerDaoImpl  implements  FakerDao{

    //List works as database
    private List<User> user;

    public FakerDaoImpl() {
        Faker faker = new Faker();
        user = new ArrayList<>();
    }

    @Override
    public List<User> getAllUsers() {
        return this.user;
    }

    @Override
    public User getUserById(IdNumber id) {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}
