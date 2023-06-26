
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 19/06/2023
  Time: 7:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        body{
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1{
            color: blue;
            text-align: center;
        }
        table{
            width: 100%;
            border-collapse: collapse;
        }
        th,td{
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ccc;
        }
        tr:nth-child(even){
            background-color: #f2f2f2;
        }
        tr:hover{
            background-color: #e0e0e0;
        }

        form{
            margin-left: 1150px;
        }
        p {
            margin-left: 1150px;
        }

    </style>
</head>
<body>

<h1>Employee List</h1>
<a href="/add"><input type="button" value="Create Employee"></a>
<br>
<table>
    <tr>
        <th>Employee ID</th>
        <th>Employee Name</th>
        <th>Birthday</th>
        <th>Address</th>
        <th>Position</th>
        <th>Department</th>
        <th>Edit</th>
        <th>Delete</th>

    </tr>

    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.employeeID}</td>
            <td>${employee.name}</td>
            <td>${employee.birth}</td>
            <td>${employee.address}</td>
            <td>${employee.position}</td>
            <td>${employee.department}</td>
            <td><a href="/edit?id=${employee.employeeID}"><input type="button" value="Edit"></a></td>
            <td><a href="/delete?id=${employee.employeeID}"><input type="button" value="Delete"></a></td>


        </tr>
    </c:forEach>
</table>

</body>
</html>
