package com.example.trek.user;

import com.example.trek.user.STAR_TREK_USER;
import org.springframework.data.repository.CrudRepository;

public abstract class UserRepository implements CrudRepository<STAR_TREK_USER, Integer> {
}
