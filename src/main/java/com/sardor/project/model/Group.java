package com.sardor.project.model;

import com.sardor.project.model.Student;

import java.util.ArrayList;

public class Group {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {


        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setName("Bob");
        student.setScores("2,4,5,7,4");
        students.add(student);

        Student student2 = new Student();
        student2.setName("Anna");
        student2.setScores("1,1,2,3,2");
        students.add(student2);

        Student student3 = new Student();
        student3.setName("Stan");
        student3.setScores("10,8,2,3,2");
        students.add(student3);





        int max = 0;
        String name = " ";

        for (Student studentElement : students) {
            int average = 0;
            int sum = 0;
            int [] scoresArr = convertStringToIntArr(student.getScores());
            for (int i = 0; i < scoresArr.length; i++) {
                sum = sum + scoresArr[i];
                average = sum / scoresArr.length;
            }
            if (max < average) {
                max = average;
                name = studentElement.getName();
            }
            System.out.println(max);
            System.out.println("Name of the best student: " + name);


        }
    }
    private static int[] convertStringToIntArr(String stringArr) {
        String[] scores = stringArr.split(",");
        int[] scoresArr = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            scoresArr[i] = Integer.parseInt(scores[i]);
        }
        return scoresArr;
    }
    }






