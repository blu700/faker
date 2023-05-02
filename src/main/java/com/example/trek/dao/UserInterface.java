package com.example.trek.dao;

import com.example.trek.model.STAR_TREK_USER;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserInterface<U> {

    void createDatabase(boolean deleteTables);

    void dropTables();

    void addSampleUsers();

    List<STAR_TREK_USER> getAllUsers();
}
