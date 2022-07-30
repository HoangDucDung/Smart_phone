<%-- 
    Document   : EditProducts
    Created on : Mar 3, 2022, 9:47:13 AM
    Author     : FPTSHOP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="edit.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="head">
            <h1>Smartphone Edids</h1>
        </div>
        <div class="body">
            <form action="EditProduct?pid=${product.getProductId()}" method="post">
                <table>
                    <tr>
                        <th>ProductId</th>
                        <th>ProductName</th>
                        <th>Supplier</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>img</th>
                    </tr>
                    <tr>
                            <td>${product.getProductId()}</td>
                            <td><input type="text" name="pName" value="${product.getProductName()}"></td>
                            <td>
                                <select name="pSup">
                                    <c:forEach items="${supplier}" var="s">
                                        <option value="${s.getSupplierId()}" 
                                                ${product.getSupplier().getSupplierId()==s.getSupplierId()?"selected":""}>
                                            ${s.getSupplierName()}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td><input type="number" name="pQuan" value="${product.getQuantity()}"></td>
                            <td><input type="text" name="pPrice" value="${product.getPrice()}"></td>
                            <td><input type="text" name="pImg" value="${product.getImg()}" style="width: 330px"></td>
                    </tr>
                </table>
                    <p style="text-align: center; margin-top: 5px"><button type="submit">Edit</button></p>
            </form>     
                            <h3 style="text-align: center">${mess}</h3>
        </div>
        <div style="display: flex; justify-content: space-between; margin-top: 25px">
            <a href="Manager">Quay lai Manager</a>
            <a href="Smartphone">Quay lai Home</a>
        </div>
    </body>
</html>
