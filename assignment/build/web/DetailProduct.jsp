<%-- 
    Document   : DetailProduct
    Created on : Mar 7, 2022, 11:25:03 AM
    Author     : FPTSHOP
--%>

<%@page import="Models.Login"%>
<%@page import="Models.Products"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
    ArrayList<Products> plist = (ArrayList<Products>) session.getAttribute("productlist");
    Login l = new Login();
    int sos = 0;
    if(session.getAttribute("Acc")!=null){
        l =(Login) session.getAttribute("Acc");
    }
    if(session.getAttribute("sizecart"+l.getUser())!=null){
        sos = Integer.parseInt(session.getAttribute("sizecart"+l.getUser()).toString());
    }
    System.out.println("null owr day");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="DetailProduct.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="head">
            <div class="logo">
                <a href="Smartphone"><img src="horizontal_on_white_by_logaster.png" alt="logo"></a>
            </div>
            <div class="sup">
                <ul class="lsup">
                    <li><a href="Smartphone?sid=1"><h3>Apple</h3></a></li>
                    <li><a href="Smartphone?sid=2"><h3>SamSung</h3></a></li>
                    <li><a href="Smartphone?sid=3"><h3>OPPO</h3></a></li>
                    <li><a href="Smartphone?sid=4"><h3>ViVo</h3></a></li>
                    <li><a href="Smartphone?sid=5"><h3>Vsmart</h3></a></li>
                </ul>
            </div>
            <div class="work">
                <ul class="lwork">
                    <c:if test="${sessionScope.Acc.getAdmin() == 1}">
                        <li><a href="Manager"><i class="fa fa-tasks"></i>Manager</a></li> 
                    </c:if>
                    <c:if test="${sessionScope.Acc != null}">
                    <li class="cart"><a href="ViewCart"><i class="fa fa-shopping-cart" style="font-size: 25px"></i>
                        </a><span style="margin-right: 50px"><%=sos%></span></li>
                    </c:if>
                    <li>
                        <div>
                            <a href="Profile?uId=${Acc.getLoginID()}"><h4>${Acc.getUser()}</h4></a>
                            <c:if test="${sessionScope.Acc != null}">
                                <a href="Logout">Logout</a>
                            </c:if>
                            <c:if test="${sessionScope.Acc == null}">
                                <a href="Login">Login</a>   
                            </c:if>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
                            
        <div class="body">
            <div class="contain">
                <div class="img">
                    <img src=${product.getImg()} >
                </div>
                <div class="product">
                    <h1 style="color: #295ccf">${product.getProductName()}</h1>
                    <p style="margin-top: 10px;">Giá: <b class="price">${product.getPrice()}</b><sub style="font-size: 10px">VNĐ</sub></p>
                    <a href="AddToCart?pid=${product.getProductId()}&dt=1"><button><i class="fa fa-shopping-cart" style="font-size: 25px;"></i></button></a>
                    <table border 1px >
                        <tr>
                            <th>Tính năng</th>
                            <td>
                                <c:forEach items="${tn}" var="d">
                                    <p style="margin-left: 33px; font-size: 17px;">- ${d.getDescription()}</p>
                                </c:forEach>
                            </td>
                        </tr>
                        <tr>
                            <th>PIN</th>
                            <td><p style="margin-left: 33px; font-size: 17px;">${pin.getDescription()}</p></td>
                        </tr>
                        <tr>
                            <th>Màn hình</th>
                            <td><p style="margin-left: 33px; font-size: 17px;">${inch.getDescription()}</p></td>
                        </tr>
                        <tr>
                            <th>Chip</th>
                            <td><p style="margin-left: 33px; font-size: 17px;">${chip.getDescription()}</p></td>
                        </tr>
                    </table>
                    
                </div>
            </div>
        </div>
        <div class="bot">
            <h2>Sản phẩm bạn vừa xem</h2>
            <div class="list">
                <ul>
                    <%for (int i = plist.size()-1; i >= 0; i--) {%>
                    <li>
                        <a href="DetailProduct?pid=<%=plist.get(i).getProductId()%>">
                            <img src="<%=plist.get(i).getImg()%>" class="imgbot">
                            <p><%=plist.get(i).getProductName()%></p>
                            <p style="color: red"><%=plist.get(i).getPrice()%></p>
                        </a>
                    </li>   
                    <%}%>
                </ul>
            </div>
        </div>
    </body>
</html>
