package com.example.fakerattempt.dao;

import com.example.fakerattempt.model.STAR_TREK_USER;
import org.springframework.data.repository.CrudRepository;

public abstract class UserRepository implements CrudRepository<STAR_TREK_USER, Integer> {
}
