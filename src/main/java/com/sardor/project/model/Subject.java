package com.sardor.project.model;

/**
 * Created by Sardor on 04.07.2017.
 */
public class Subject {
    String name;


    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject(String name, int amount) {

        this.name = name;
    }
}
