package com.sardor.project.model;

/**
 * Created by Sardor on 25.08.2017.
 */
public class Janitor extends Employee {
    public Janitor(String surname, String name, int age, String contactNumber, Double salary, String rank) {
        super(surname, name, age, contactNumber, salary, rank);
    }


    public void toWork(){
        System.out.println(" I am cleaning ");
    }
}
