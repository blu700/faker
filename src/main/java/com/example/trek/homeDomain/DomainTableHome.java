package com.example.trek.homeDomain;

import jakarta.persistence.*;

@Entity
@Table
public class DomainTableHome {

    @Id
    @GeneratedValue
    @Column(name = "HOME_ID")
    String id;

    @Column(name = "HOME_LOCATION")
    String home;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }
}
