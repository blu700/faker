package com.example.fakerattempt.dao;

import com.example.fakerattempt.model.STAR_TREK_USER;

import java.util.List;

public interface UserInterface<U> {

    void createDatabase(boolean deleteTables);

    void dropTables();

    void addSampleUsers();

    List<STAR_TREK_USER> getAllUsers();
}
