package com.example.trek.homeDomain;

import java.util.List;

public interface HomeDomainDAO<U> {

    void createDatabase(boolean delete);

    void dropTables();

    void addHomeLocations(String homes[]);

    List<DomainTableHome> getAllLocations();
}
