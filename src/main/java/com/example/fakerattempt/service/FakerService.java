package com.example.fakerattempt.service;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fakerattempt.dao.UserDAO;
import com.example.fakerattempt.model.User;

@RestController
public class FakerService {

    @Autowired
    UserDAO userDAO;

    @GetMapping("/db/init")
	public ResponseEntity<List<User>> initializeDatabase(@RequestParam(value = "delete", defaultValue = "false") Boolean delete) {
        
        // Create database if delete = true
        userDAO.createDatabase(delete);

        // add faker users to database
        userDAO.addSampleUsers();

        // retrieve faker users
        return ResponseEntity.ok(userDAO.getAllUsers());
	}

}
