<%-- 
    Document   : AddProduct
    Created on : Mar 3, 2022, 11:29:56 AM
    Author     : FPTSHOP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="add.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="head">
            <h1>Add Product</h1>
        </div>
        <div class="body">
            <form action="AddProduct" method="post">
                <table>
                    <tr>
                        <td>ProductName: </td>
                        <td>
                            <div class="input">
                                <input type="text" name="pname" value="${name}">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Supplier: </td>
                        <td>
                            <div class="input sup">
                                <select name="psub"> 
                                    <c:forEach items="${supplier}" var="s">
                                        <option value="${s.getSupplierId()}">${s.getSupplierName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Quantity:</td>
                        <td>
                            <div class="input">
                                <input type="number" name="pquan" value="${quantity==0?"":quantity}">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Price:</td>
                        <td>
                            <div class="input">
                                <input type="text" name="pprice" value="${price}">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Img:</td>
                        <td>
                            <div class="input">
                                <input type="text" name="pimg" value="${img}">
                            </div>
                        </td>
                    </tr>
                </table>
                <button type="submit" style="text-align: center">Add</button>
            <p style="text-align: center">${mess}</p>
            <a href="Manager" style="display: block; margin-left: 10px">Manager</a>
            </form>
        </div>
    </body>
</html>
