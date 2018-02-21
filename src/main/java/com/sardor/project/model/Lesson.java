package com.sardor.project.model;

/**
 * Created by Sardor on 07.07.2017.
 */
public class Lesson {
    int id;
    Employee teacher;
    Subject subject;

    public Lesson(int id, Employee teacher, Subject subject) {
        this.id = id;
        this.teacher = teacher;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getTeacher() {
        return teacher;
    }

    public void setTeacher(Employee teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
