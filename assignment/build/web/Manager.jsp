<%-- 
    Document   : Manager
    Created on : Mar 2, 2022, 9:58:32 PM
    Author     : FPTSHOP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Manager.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="head">
            <h1>Smartphone Manager</h1>
        </div>
        <div class="body">
            <div class="add">
                <a href="SetAdmin">Set Admin</a>
                <a href="AddProduct">Add Product</a>
            </div>
            <table>
                <tr>
                    <th>ProductId</th>
                    <th>ProductName</th>
                    <th>Supplier</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Detail</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <c:forEach  items="${plist}" var="p">
                    <tr>
                        <td>${p.getProductId()}</td>
                        <td>${p.getProductName()}</td>
                        <td>${p.getSupplier().getSupplierName()}</td>
                        <td>${p.getQuantity()}</td>
                        <td>${p.getPrice()}<sub>VND</sub></td>
                        <td><a href="Detail?pid=${p.getProductId()}">View</a></td>
                        <td><a href="EditProduct?pid=${p.getProductId()}">Edit</a></td>
                        <td><a href="DeleteProduct?pid=${p.getProductId()}">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
            <a href="Smartphone" style="display: block; margin-top: 20px">Quay lại home</a>
        </div>
    </body>
</html>
