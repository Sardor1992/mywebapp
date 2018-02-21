package com.sardor.project.model;

/**
 * Created by Sardor on 25.08.2017.
 */
public class LabAssistant extends Employee {
    public LabAssistant(String surname, String name, int age, String contactNumber, Double salary, String rank) {
        super(surname, name, age, contactNumber, salary, rank);
    }

    @Override
    public void toWork() {
        System.out.println("i am doing lab!");
    }
}
