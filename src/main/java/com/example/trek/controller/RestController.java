package com.example.trek.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.trek.dao.UserDAO;
import com.example.trek.model.STAR_TREK_USER;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    UserDAO userDAO;

    @GetMapping("/db/init")
	public ResponseEntity<List<STAR_TREK_USER>> initializeDatabase(@RequestParam(value = "delete", defaultValue = "false") Boolean delete) {
        
        // Create database if delete = true
        userDAO.createDatabase(delete);

        // add faker users to database
        userDAO.addSampleUsers();

        // retrieve faker users
        return ResponseEntity.ok(userDAO.getAllUsers());
	}

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/api/users")
    public ResponseEntity<List<STAR_TREK_USER>> findAll() {
        return ResponseEntity.ok(userDAO.getAllUsers());
    }

    //TODO: create rest controller that add more random users || allow CORS
    //TODO: create rest controller that deletes the table || allow CORS
    //TODO: create rest controller that adds data from form input


}
