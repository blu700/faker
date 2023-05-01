package com.example.trek.dao;

import com.example.trek.model.STAR_TREK_USER;
import com.github.javafaker.IdNumber;

import java.util.List;

public interface FakerDao{

    List<STAR_TREK_USER> getAllUsers();
    STAR_TREK_USER getUserById(IdNumber id);
    void saveUser(STAR_TREK_USER user);
    void deleteUser(STAR_TREK_USER user);

}
