package com.example.trek.dao;

import com.example.trek.model.STAR_TREK_USER;
import org.springframework.data.repository.CrudRepository;

public abstract class UserRepository implements CrudRepository<STAR_TREK_USER, Integer> {
}
