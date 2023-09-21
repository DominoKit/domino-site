package org.dominokit.pages.shared.model;

import java.util.List;

public class Country {
    private String name;
    private List<String> cities;

    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }
}
