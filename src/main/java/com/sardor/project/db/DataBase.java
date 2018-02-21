package com.sardor.project.db;

import com.sardor.project.model.Employee;
import com.sardor.project.model.Janitor;
import com.sardor.project.model.School;
import com.sardor.project.model.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static Connection con;
    private static DataBase instance;
    private static String URL = "jdbc:mysql://localhost:3306/school";


    public DataBase() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/school";
            con = DriverManager.getConnection(url, "root", "sardor");
        } catch (ClassNotFoundException e) {
            throw new Exception(e);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public static synchronized DataBase getInstance() throws Exception {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {
        getInstance();
        saveStudents();
        saveEmployees();
        select();
        getAllSchools();
        selectSchool();
    }

    public static List saveEmployees() throws Exception {
        ArrayList<Employee> empl = new ArrayList<>();
        try {

            BufferedReader reader = new BufferedReader(new FileReader("C:/Coding/employee.txt"));
            String s = null;

            while ((s = reader.readLine()) != null){
                Employee employee  = new Janitor(" ", " ", 0,  " ", 0.00, " ");
                String tmp [] = s.split(",");
                employee.setSurname(tmp[0]);
                employee.setName(tmp[1]);
                employee.setAge(Integer.parseInt(tmp[2]));
                employee.setContactNumber(tmp[3]);
                employee.setSalary(Double.parseDouble(tmp[4]));
                employee.setRank(tmp[5]);
                empl.add(employee);
            }
            reader.close();

        }catch (NullPointerException ex){
        }

        for (Employee em : empl)
        {
            System.out.println(em.toString());

            Class.forName("com.mysql.jdbc.Driver");

            try {

                Connection con = DriverManager.getConnection(URL, "root", "sardor");
                PreparedStatement stmt = null;

                try{

                    stmt = con.prepareStatement("insert  into employee (surname, name, age, contact_number, salary, rank) values (?, ?, ?, ?, ?, ?)");
                    stmt.setString(1, em.getSurname());
                    stmt.setString(2, em.getName());
                    stmt.setString(3, String.valueOf(em.getAge()));
                    stmt.setString(4, em.getContactNumber());
                    stmt.setString(5, String.valueOf(em.getSalary()));
                    stmt.setString(6, em.getRank());
                    stmt.executeUpdate();

                }finally {
                    if (stmt != null){
                        stmt.close();
                    }
                    con.close();
                }
            } catch (SQLException e) {

            }
        }

        return empl;
    }


    public static List saveStudents() throws Exception {
        ArrayList<Student> students = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:/Coding/file.txt"));
            String s = null;

            while ((s = reader.readLine()) != null) {

                String tmp[] = s.split(",");
                Student student = new Student();
                student.setSurname(tmp[0]);
                student.setName(tmp[1]);
                student.setDateOfBirth(tmp[2]);
                student.setScores(tmp[3]);
                student.setGroupNumber(Integer.parseInt(tmp[4]));
                student.setSex(tmp[5]);
                students.add(student);
            }
            reader.close();

        } catch (ArrayIndexOutOfBoundsException ex) {
        }

        for (Student st : students) {

            System.out.println(st.toString());

            String URL = "jdbc:mysql://localhost:3306/school";
            Class.forName("com.mysql.jdbc.Driver");

            try {
                Connection con = DriverManager.getConnection(URL, "root", "sardor");
                PreparedStatement stmt = null;
                try {

                    stmt = con.prepareStatement("insert into students (surname, name, year_of_birth, scores, group_number, sex )" +
                            "values (?,?,?,?,?,?)");

                    stmt.setString(1, st.getSurname());
                    stmt.setString(2, st.getName());
                    stmt.setString(3, (st.getDateOfBirth()));
                    stmt.setString(4, st.getScores());
                    stmt.setString(5, String.valueOf(st.getGroupNumber()));
                    stmt.setString(6, st.getSex());
                    stmt.executeUpdate();

                } finally {
                    if (stmt != null) {
                        stmt.close();
                    }
                    con.close();
                }
            } catch (SQLException ex) {

            }

        }

        System.out.println();
        return students;
    }

    public static void select() throws SQLException {

        List<Student> students = new ArrayList<Student>();

        Statement st = null;
        ResultSet rs = null;

        try {

            st = con.createStatement();
            rs = st.executeQuery("Select * from students");

            while (rs.next())
            {
                Student student = new Student();
                student.setSurname(rs.getString("surname"));
                student.setName(rs.getString("name"));
                student.setDateOfBirth(rs.getString("year_of_birth"));
                student.setScores(rs.getString("scores"));
                student.setGroupNumber(rs.getInt("group_number"));
                student.setSex(rs.getString("sex"));

                System.out.println(student);
            }

        }finally {
            if (rs != null)
            {
                rs.close();
            }
            if (st != null)
            {
                st.close();
            }
        }

    }

    public static List<School> getAllSchools() throws Exception {
        // Делай потом продолжим
        Class.forName("com.mysql.jdbc.Driver");

        List<School> schools = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:/Coding/Schools.txt"));
            String s = null;

            while ((s = reader.readLine()) != null) {
                School school = new School();
                school.setName(s);

                schools.add(school);
            }
            reader.close();

        } catch (ArrayIndexOutOfBoundsException ex) {
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (School sch : schools) {
            try {
                Connection con = DriverManager.getConnection(URL, "root", "sardor");
                PreparedStatement stmt = null;
                try {

                    stmt = con.prepareStatement("insert into schools (name)" +
                            "values (?)");

                    stmt.setString(1, sch.getName());
                    stmt.executeUpdate();

                } finally {
                    if (stmt != null) {
                        stmt.close();
                    }
                    con.close();
                }
            } catch (SQLException ex) {
            }
        }
        return selectSchool();
    }

    public static List<School> selectSchool() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Statement st = null;
        ResultSet rs = null;
        List<School> schools = new ArrayList<>();

        try {
            con =  DriverManager.getConnection(URL, "root", "sardor");
            st = con.createStatement();
            rs = st.executeQuery("Select * from schools");

            while (rs.next()) {

                School school = new School();
                school.setName(rs.getString("name"));
               schools.add(school);
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        }
        return schools;
    }
}
