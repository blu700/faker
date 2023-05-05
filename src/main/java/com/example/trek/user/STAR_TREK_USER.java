package com.example.trek.user;

import jakarta.persistence.*;

@Entity
@Table
public class STAR_TREK_USER {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    String id;

    @Column(name = "USER_HOME")
    String home;

    @Column(name = "USER_NAME")
    String name;

    @Column(name = "USER_SPECIES")
    String species;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
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


}
