<%-- 
    Document   : Order
    Created on : Mar 12, 2022, 4:44:51 PM
    Author     : FPTSHOP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Order.css">
        <title>JSP Page</title>
    </head>
    <body>
        <body>
        <div class="head">
            <h1>Order</h1>
        </div>
        <div class="body">
            <div class="cart">
                <table>
                    <tr>
                        <th>ProductName</th>
                        <th style="margin-right: 10px">Quantity</th>
                        <th>Price</th>
                    </tr>
                    <c:forEach items="${cartlist}" var="c">
                        <tr>
                            <td>${c.getProductName()}</td>
                            <td>${c.getQuantity()}</td>
                            <td>${c.getPrice()}</td>
                        </tr>
                    </c:forEach>
                        <tr>
                            <td>Total: </td>
                            <td>${totalQuan}</td>
                            <td>${totalprice}</td>
                        </tr>
                        <tr><td><a href="ViewCart">quay lại cart</a></td></tr>
                </table>
            </div>
            <div class="order">
                <form action="Order" method="post">
                    <table>
                        <tr>
                            <td>CustomerName:</td>
                            <td>
                                <div class="input">
                            <input type="text" name="Name">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>shippers:</td>
                            <td>
                                <select name="shipper">
                                    <c:forEach items="${slist}" var="s">
                                        <option value="${s.getShipperID()}">${s.getShipperName()}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Address:</td>
                            <td>
                                <div class="input">
                                    <input type="text" name="Address">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>Phone:</td>
                            <td>
                                <div class="input">
                                    <input type="text" name="Phone" placeholder="${warmP}">
                                </div>
                            </td>
                        </tr>
                    </table>
                    <button type="submit" style="display: block; margin: auto">Order</button>
                    <p style="text-align: center">${mess}</p>
                </form>
            </div>
        </div>
    </body>
</html>
