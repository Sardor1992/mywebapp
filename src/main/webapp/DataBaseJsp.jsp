<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.sardor.project.db.DataBase" %>
<%@ page import="com.sardor.project.model.School" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Data Base Jsp</title>


    <c:forEach items="${requestScope.stud}" var="St">
        <c:out value="${St.name}"></c:out>
        <c:out value=" ${St.surname}"></c:out>
        <c:out value="${St.sex}"></c:out>
        <c:out value="${St.groupNumber}"></c:out>
        <c:out value="${St.dateOfBirth}"></c:out>
        <c:out value="${St.scores}"></c:out>
    </c:forEach>

</head>
<body>

</body>
</html>
