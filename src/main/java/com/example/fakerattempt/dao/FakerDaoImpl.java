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
        user.add(new User(1, faker.starTrek().character(), faker.starTrek().location(),faker.starTrek().specie()));
        user.add(new User(2, faker.starTrek().character(), faker.starTrek().location(),faker.starTrek().specie()));
        user.add(new User(3, faker.starTrek().character(), faker.starTrek().location(),faker.starTrek().specie()));
        user.add(new User(4, faker.starTrek().character(), faker.starTrek().location(),faker.starTrek().specie()));
        user.add(new User(5, faker.starTrek().character(), faker.starTrek().location(),faker.starTrek().specie()));
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
