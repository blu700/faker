package com.example.fakerattempt.model;

import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;


public class User {

    Faker faker = new Faker();

    Number id;

    String name = faker.starTrek().character();

    String home = faker.starTrek().location();

    String species = faker.starTrek().specie();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Faker getFaker() {
        return faker;
    }

    public void setFaker(Faker faker) {
        this.faker = faker;
    }

    public String getId() {
        return id.toString();
    }

    public void setId(Number id) {
        this.id = id;
    }

    public User(Number id, String name, String home, String species){
        this.id = id;
        this.name = name;
        this.home = home;
        this.species = species;

    }


}
