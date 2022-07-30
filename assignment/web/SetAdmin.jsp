<%-- 
    Document   : SetAdmin
    Created on : Mar 11, 2022, 3:47:58 PM
    Author     : FPTSHOP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="SetAdmin.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="head">
            <h1>Smartphone Set Admin</h1>
        </div>
        <form action="SetAdmin" method="post">
            <div class="body">
                <div class="add">
                    <a href="SetAdmin">Set Admin</a>
                    <a href="Manager">Manager</a>
                </div>
                <table>
                    <tr>
                        <th>User</th>
                        <th>Gender</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Admin</th>
                    </tr>
                    <c:forEach  items="${llist}" var="l">
                        <tr>
                            <td>${l.getUser()}</td>
                            <td>${l.getGender()}</td>
                            <td>${l.getPhone()}</td>
                            <td>${l.getEmail()}</td>
                            <td><input type="checkbox" name="${l.getLoginID()}" ${l.getAdmin()==1?"checked":""}></td>
                        </tr>
                    </c:forEach>
                </table>
                <button type="submit" style="display: block; margin: auto; margin-top: 10px">ADD</button>
                <a href="Smartphone" style="display: block; margin-top: 10px">Quay lại home</a>
            </div>
        </form>
    </body>
</html>
