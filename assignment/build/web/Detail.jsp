<%-- 
    Document   : Detail
    Created on : Mar 3, 2022, 5:06:57 PM
    Author     : FPTSHOP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Models.Detail"%>
<%@page import="Models.Categorie"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="detail.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="head">
            <h1>Detail ${product.getProductName()}</h1>
        </div>
        <div class="body">
            <form action="Detail?pid=${product.getProductId()}" method="post">
                <table>
                    <tr>
                        <th>Đặc điểm</th>
                        <th>Gói</th>
                        <th>Mô tả</th>
                    </tr>
                    <tr>
                        <td>Tính năng:</td>
                        <td></td>
                        <td>
                            <c:forEach items="${clist}" var="c">
                                <input type="checkbox" name="tn${c.getCategorieId()}" value="${c.getCategorieId()}"
                                       <c:forEach items="${detail1}" var="d">
                                           ${d.getCategorieId()==c.getCategorieId()?"checked":""}
                                       </c:forEach>
                                       >${c.getCategorieName()}
                            </c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <td>PIN:</td>
                        <td>
                            <div class="input">
                                <select style="font-size: 14px; height: 28px;" name="PIN">
                                <option value="5"${detail2.getCategorieId()==5?"selected":""}>Dưới 3000 mah</option>
                                <option value="6"${detail2.getCategorieId()==6?"selected":""}>Từ 3000 - 4000 mah</option>
                                <option value="7"${detail2.getCategorieId()==7?"selected":""}>Trên 4000 mah</option>  
                            </select>
                            </div>
                        </td>
                        <td><div class="input a"><input type="text" name="pin" placeholder="Mô tả chi tiết"
                                                        value="${detail2.getDescription()}"></div></td>
                    </tr>
                    <tr>
                        <td>Màn hình: </td>
                        <td>
                            <div class="input">
                                <select style="font-size: 14px; height: 28px;" name="INCH">
                                <option value="8"${detail3.getCategorieId()==8?"selected":""}>Dưới 6.0 inch</option>
                                <option value="9"${detail3.getCategorieId()==9?"selected":""}>Trên 6.0 inch</option>
                            </select>
                            </div>
                        </td>
                        <td><div class="input a"><input type="text" name="inch" placeholder="Mô tả chi tiết"
                                                        value="${detail3.getDescription()}"></div></td>
                    </tr>
                    <tr>
                        <td>Chip: </td>
                        <td>
                            <div class="input">
                                <select style="font-size: 14px; height: 28px;" name="CHIP">
                                <option value="10"${detail4.getCategorieId()==10?"selected":""}>Apple A</option>  
                                <option value="11"${detail4.getCategorieId()==11?"selected":""}>Exynos</option>  
                                <option value="12"${detail4.getCategorieId()==12?"selected":""}>Snapdragon</option>  
                                <option value="13"${detail4.getCategorieId()==13?"selected":""}>Spreadtrum</option>  
                                <option value="14"${detail4.getCategorieId()==14?"selected":""}>MediaTek Helio</option>  
                                <option value="15"${detail4.getCategorieId()==15?"selected":""}>MediaTek Dimensity</option>  
                                <option value="16"${detail4.getCategorieId()==16?"selected":""}>Helio</option>  
                            </select>
                            </div>
                        </td>
                        <td><div class="input a"><input type="text" name="chip" placeholder="Mô tả chi tiết"
                                                        value="${detail4.getDescription()}"></div></td>
                    </tr>
                </table>
                        <button type="submit" value="${check}" name="button">${check}</button>
                        <p style="text-align: center">${mess}</p>
            </form>
            
        </div>
    </body>
</html>
