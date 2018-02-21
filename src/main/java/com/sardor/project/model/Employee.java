package com.sardor.project.model;

/**
 * Created by Sardor on 02.07.2017.
 */
public abstract class Employee implements Worker {
    String surname;
    String name;
    int age;
    String contactNumber;
    Double salary;
    String rank;


    public String toString(){
            return this.surname + " " + this.name + " " + this.age + " " + this.contactNumber + " " + this.salary + " " + this.rank;
    }

    public Employee(String surname, String name, int age, String contactNumber, Double salary, String rank) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.salary = salary;
        this.rank = rank;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public abstract void toWork();

}
