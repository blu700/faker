package com.example.trek.user;

import com.example.trek.user.STAR_TREK_USER;

import java.util.List;

public interface UserInterface<U> {

    void createDatabase(boolean deleteTables);

    void dropTables();

    void addSampleUsers();

    List<STAR_TREK_USER> getAllUsers();

    void addNewUser(STAR_TREK_USER stu);
}
