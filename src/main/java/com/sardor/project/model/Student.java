package com.sardor.project.model;

/**
 * Created by Sardor on 02.07.2017.
 */
public class Student implements Studying {

    String surname;
    String name;
    String dateOfBirth;
    String scores;
    int groupNumber;
    String sex;

    public String toString()
    {
        return this.surname + " " + this.name + " " + this.dateOfBirth + " " + this.scores + " " + this.groupNumber + " " + this.sex;
    }


    public Student() {
    }

    public void setScores(String scores) {
        this.scores = scores;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
       this.groupNumber = groupNumber;
    }

    public Student(int groupNumber) {

        groupNumber = groupNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getScores() {

        return scores;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public void toStudy() {
        System.out.println("I am studying");
    }
}
