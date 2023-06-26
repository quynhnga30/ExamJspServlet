<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Add</title>
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
    <h1>Create Employee </h1>
    <table>
        <tr>
            <td>FullName</td>
            <td><input type="text" name="name" placeholder="name"></td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td><input type="date" name="birth"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" placeholder="Address"></td>
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
            <td><input type="submit" value="SUBMIT"></td>
        </tr>
    </table>
</form>
</body>
</html>
