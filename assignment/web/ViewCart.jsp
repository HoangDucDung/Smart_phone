<%-- 
    Document   : ViewCart
    Created on : Mar 12, 2022, 11:14:09 AM
    Author     : FPTSHOP
--%>

<%@page import="Models.Products"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.Login"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        Login l = (Login) session.getAttribute("Acc");
        ArrayList<Products> plist = (ArrayList<Products>) session.getAttribute("Cart"+l.getUser());
        String mess = request.getAttribute("mess").toString();
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="ViewCart.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="head">
            <h1>Cart of ${Acc.getUser()}</h1>
        </div>
        <div class="body">
            <%if(plist.size()==0){%>
                <%if(mess == ""){%>
                    <h1 style="text-align: center">Không có sản phẩm trong giỏ</h1>
                <%} else {%>
                    <h1 style="text-align: center">Order thành công</h1>
                    <h2 style="text-align: center; color: red"><%=mess%></h2>
                <%}%>
            <%} else {%>
                <div class="add">
                    <a href="Order">Order</a>
                </div>

                <table>
                    <tr>
                        <th>ProductName</th>
                        <th>Quantity</th>
                        <th>Price</th>
                    </tr>
                    <%for (Products p : plist) {%>
                        <tr>
                            <td><%=p.getProductName()%></td>
                            <td><%=p.getQuantity()%></td>
                            <td><%=p.getPrice()%><sub>VND</sub></td>
                            <td><a href="AddToCart?pid=<%=p.getProductId()%>">up</a></td>
                            <td><a href="ViewCart?pid=<%=p.getProductId()%>">down</a></td>
                            <td><a href="ViewCart?pid=<%=p.getProductId()%>&del=x"><i class="fa fa-trash" style="font-size: 20px"></i></a></td>
                        </tr>
                    <%}%>
                </table>
            <%}%>
            <a href="Smartphone" style="display: block; margin-top: 20px">Quay lại home</a>
        </div>
    </body>
</html>