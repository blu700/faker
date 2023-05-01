package com.example.fakerattempt.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.fakerattempt.dao.UserDAO;
import com.example.fakerattempt.model.STAR_TREK_USER;

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

}
