package com.example.trek.dao;

import com.example.trek.model.STAR_TREK_USER;
import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakerDaoImpl  implements  FakerDao{

    //List works as database
    private List<STAR_TREK_USER> user;

    public FakerDaoImpl() {
        Faker faker = new Faker();
        user = new ArrayList<>();
    }

    @Override
    public List<STAR_TREK_USER> getAllUsers() {
        return this.user;
    }

    @Override
    public STAR_TREK_USER getUserById(IdNumber id) {
        return null;
    }

    @Override
    public void saveUser(STAR_TREK_USER user) {

    }

    @Override
    public void deleteUser(STAR_TREK_USER user) {

    }
}
