package com.example.trek.controller;


import java.net.URI;
import java.util.List;

import com.example.trek.homeDomain.DomainTableHome;
import com.example.trek.homeDomain.HomeDomainDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.trek.user.UserDAO;
import com.example.trek.user.STAR_TREK_USER;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    UserDAO userDAO;
    @Autowired
    HomeDomainDAOImpl homeDomainDAO;

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


            //COMPLETED:: Domain table for homes on front end form.

    @GetMapping("/db/dom-home-int")
    public ResponseEntity<List<DomainTableHome>> Database(@RequestParam(value = "delete", defaultValue = "false") Boolean delete) {

        // to create a new table with different locations, change the array values below
        // then rerun the mapping with '?delete=true'
        String[] homes = new String[]{"Earth", "Not Earth", "The Moon", "Not The Moon"};
        homeDomainDAO.createDatabase(delete);

        homeDomainDAO.addHomeLocations(homes);

        return ResponseEntity.ok(homeDomainDAO.getAllLocations());

    }

    @GetMapping("/api/users/edit/{id}")
    public ResponseEntity<Object> getUser(@PathVariable("id") String userId) {
        return ResponseEntity.ok(userDAO.getUser(userId));
    }

    @GetMapping("/api/homes")
    public ResponseEntity<List<DomainTableHome>> findAllLocations() {return ResponseEntity.ok(homeDomainDAO.getAllLocations());}

    @PostMapping("/api/users/add")
    public ResponseEntity<STAR_TREK_USER> postBody(@RequestBody STAR_TREK_USER stu ) {

        userDAO.addNewUser(stu);

        return ResponseEntity.created(URI.create(String.format("/user/%s", stu))).body(stu);
    }

    @PostMapping("/api/edit-existing")
    public ResponseEntity<STAR_TREK_USER> editCurrent(@RequestBody STAR_TREK_USER stu) {

        userDAO.updateUser(stu);

        return ResponseEntity.ok(stu);

    }

}
