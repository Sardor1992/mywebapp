package com.sardor.project;

import com.sardor.project.db.DataBase;
import com.sardor.project.model.Employee;
import com.sardor.project.model.School;
import com.sardor.project.model.Student;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet ("/HelloServlet")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

       /* PrintWriter pw = resp.getWriter();
        pw.println("<b> Список школ</b>");
        pw.println("<table>");
        try {
            List l = DataBase.getAllSchools();

            for ( Iterator it = l.iterator(); it.hasNext();)
            {
                School sch = (School) it.next();
                pw.println("<tr>");
                pw.println("<td>" + sch.getName() + "</td>");
                pw.println("</tr>");
                req.setAttribute("l", l);

            }

        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (Exception e) {

        }
        pw.println("</table>");*/

       List<School> schoolList = new ArrayList<School>();
       School sch = new School();
       sch.getName();
       schoolList.add(sch);
       req.setAttribute("schoolList", schoolList);

       /* pw.println("<b> Список рабочих</b>");
        pw.println("<table>");

        try {
            List emp = DataBase.saveEmployees();

            for ( Iterator it = emp.iterator(); it.hasNext();)
            {
                Employee em = (Employee) it.next();
                pw.println("<tr>");
                pw.println("<td>" + em.getName());
                pw.println("<td>" + em.getSurname());
                pw.println("<td>" + em.getAge());
                pw.println("<td>" + em.getRank());
                pw.println("<td>" + em.getSalary());
                pw.println("<td>" + em.getContactNumber());
                pw.println("</tr>");
                req.setAttribute("emp", emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        pw.println("</table>");


        pw.println("<b> Список студентов </b>");*/



          //List<Student> stud = DataBase.saveStudents();
            List<Student> stud = new ArrayList<Student>();

        try {

               for ( Iterator it = stud.iterator(); it.hasNext();) {
                   Student student = (Student) it.next();
                   student.getGroupNumber();
                   student.getName();
                   student.getSurname();
                   student.getSex();
                   student.getDateOfBirth();
                   student.getScores();
                   stud.add(student);
                   req.setAttribute("stud", stud);

           }


        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("url", "https://DataBase.jsp");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(req, resp);
    }
}