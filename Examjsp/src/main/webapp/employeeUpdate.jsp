<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 26/06/2023
  Time: 7:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Update</title>
    <style>
        body{
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            color: #333;
        }
        form {
            width: 300px;
            margin-top: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }

    </style>
</head>
<body>
<form method="POST">
    <h1>Update Employee</h1>
    <table>
        <tr>
            <td>FullName</td>
            <td><input type="text" name="name" value="${employee.name}" placeholder="name"></td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td><input type="date" value="${employee.birth}" name="birth"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" value="${employee.address}" placeholder="Address"></td>
        </tr>
        <tr>
            <td>Position</td>
            <td><input type="text" name="position" placeholder="position"></td>
        </tr>
        <tr>
            <td>Department</td>
            <td><input type="text" name="department" placeholder="department"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Update"></td>
        </tr>
    </table>
</form>

</body>
</html>
