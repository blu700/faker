package com.example.fakerattempt.dao;

import com.example.fakerattempt.model.STAR_TREK_USER;
import com.github.javafaker.IdNumber;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FakerDao{

    List<STAR_TREK_USER> getAllUsers();
    STAR_TREK_USER getUserById(IdNumber id);
    void saveUser(STAR_TREK_USER user);
    void deleteUser(STAR_TREK_USER user);

}
