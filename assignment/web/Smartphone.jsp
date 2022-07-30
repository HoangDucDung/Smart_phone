<%-- 
    Document   : Smartphone
    Created on : Mar 2, 2022, 5:37:56 PM
    Author     : FPTSHOP
--%>

<%@page import="Models.Login"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        Login l = new Login();
        if(request.getAttribute("Acc")!=null){
            l = (Login) request.getAttribute("Acc");
        }
        int size = Integer.parseInt(request.getAttribute("sizecart").toString());
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="sm.css">
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
        <div class="filter">
            <form action="Smartphone" method="get">
                <p class="search"><input type="text" name="search" value="${search}">
                            <button type="submit" style="background: none; outline: none;border: none;">
                                <i class="fa fa-search" style="font-size: 21px; margin-top: 2px;"></i>
                            </button>
                        </p>
            </form>
        </div>
        <div class="work">
            <ul class="lwork">
                <c:if test="${sessionScope.Acc.getAdmin() == 1}">
                    <li><a href="Manager"><i class="fa fa-tasks"></i>Manager</a></li> 
                </c:if>
                <c:if test="${sessionScope.Acc != null}">
                <li class="cartview">   <a href="ViewCart"><i class="fa fa-shopping-cart" style="font-size: 25px"></i></a>
                    <span style="font-size: 18px"><%=size%></span>
                </li>
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
    <div class="title">
        <h1>Smartphone</h1>
        <p>Cửa hàng điện thoại Smartphone</p>
    </div>
    <div class="body">
        <div class="Category">
            <div class="cost">
                <h4>Tính năng đặc biệt</h4>
                <ul>
                    <a href="Smartphone?cid=1"><li>Bảo mật vân tay</li></a>
                    <a href="Smartphone?cid=2"><li>Nhận diện khuôn mặt</li></a>
                    <a href="Smartphone?cid=3"><li>Chống nước & bụi</li></a>
                    <a href="Smartphone?cid=4"><li>Sạc nhanh</li></a>
                </ul>
            </div>
            <div class="cost">
                <h4>Dung lượng PIN</h4>
                <ul>
                    <a href="Smartphone?cid=5"><li>Dưới 3000 mah</li></a>
                    <a href="Smartphone?cid=6"><li>Từ 3000 - 4000 mah</li></a>
                    <a href="Smartphone?cid=7"><li>Trên 4000 mah</li></a>
                </ul>
            </div>
            <div class="cost">
                <h4>Màn hình</h4>
                <ul>
                    <a href="Smartphone?cid=8"><li>Dưới 6.0 inch</li></a>
                    <a href="Smartphone?cid=9"><li>Trên 6.0 inch</li></a>
                </ul>
            </div>
        </div>
        <div class="Products">
            <c:forEach items="${plist}" var="p">
                <div class="product">
                <a href="DetailProduct?pid=${p.getProductId()}">
                <img src=${p.getImg()} alt="">
                <h3 class="h3">${p.getProductName()}</h3>
                <h3 style="display: inline-block; margin-right: 83px;"><span style="color: red">${p.getPrice()}</span><sub style="font-size: 10px">VNĐ</sub></h3>
                </a>
                <c:if test="${p.getQuantity() != 0}">
                <a href="AddToCart?pid=${p.getProductId()}"><button class="cart"><i class="fa fa-shopping-cart" style="font-size: 25px;"></i></button></a>   
                <p style="font-size: 14px; margin-top: 8px;">Số lượng sản phẩm: ${p.getQuantity()}</p>
                </c:if>
                <c:if test="${p.getQuantity() == 0}">
                    <h2 style="display: inline; color: red">Hết hàng</h2>
                </c:if>
                </div>
            </c:forEach>
        </div>
    </div>
    <c:if test="${totalpage != 0}">
                <div class="page">
                    <table>
                        <tr>
                            <td style="width: 50px"><a href="Smartphone?page=1"><h1 style="font-size: 24px"><<</h1></a></td>
                            <c:forEach begin="1" end="${totalpage}" var="i">
                                <td><a href="Smartphone?page=${i}">${i}</a></td>
                            </c:forEach>
                                <td style="border-right: none"><a href="Smartphone?page=${page+1}">sau</a></td>
                        </tr>
                    </table>
                </div>
    </c:if>
</body>
</html>