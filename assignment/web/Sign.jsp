<%-- 
    Document   : Sign
    Created on : Feb 28, 2022, 8:44:18 PM
    Author     : FPTSHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <title>JSP Page</title>
    </head>
    <style>
        body{
            display: flex;
            width: 99vw;
            height: 97vh;
            background: url(horizontal_on_white_by_logaster.png);
            background-position: center;
        }
        .bodylogin{
            width: 100%;
            height: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        form{
            width: 525px;
            height: 570px;
            background-color: rgb(224 210 191);
            box-shadow: 4px 4px 4px 4px #d9d9d7;
        }
        form h2{
            position: relative;
            margin: 25px 0 15px 115px;
            width: fit-content;
        }
        form input{
            position: absolute;
            top: 2px;
            font-size: 14px;
            width: 243px;
            height: 35px;
            margin-left: 25px;
            border-radius: 10px;
            outline: none;
            border: none;
            background-color: rgb(235 235 235);
        }
        .input{
            width: 100%;
            height: 65px;
        }
        form p{
            position: relative;
            margin: auto;
            width: 300px;
            height: 40px;
            border-radius: 10px;
            background-color: rgb(235 235 235);
        }
        button{
            display: block;
            margin: auto;
            width: 298px;
            height: 46px;
            outline: none;
            border: none;
            border-radius: 10px;
            background-color: rgb(199 213 224);
        }
        .radio{
            position: absolute;
            font-size: 5px;
            width: 15px;
            height: 35px;
            margin-left: 7px;
            background-color: none;
        }
        .male {
            left: 84px;
            top: auto;
        }
        .female{
            right: 97px;
            top: auto;
        }
        .text{
            position: absolute;
        }
        .a{
            left: 110px;
            top: 11px;
        }
        .b{
            right: 47px;
            top: 11px;
        }
    </style>
    </head>
    <body>
        <div class="bodylogin">
            <form action="Sign" method="post">
                <h2>User Login</h2>
                <div class="input">
                    <p><i class="fas fa-address-book" style="font-size: 25px; margin-top: 8px; margin-left: 6px;"></i>
                        <input type="text" name="User" value=""></p>
                    <span style="display: block; margin-left: 116px; color: red">${user}</span>
                </div>
                <div class="input">
                    <p><i class="fas fa-lock" style="font-size: 25px; margin-top: 8px; margin-left: 6px;"></i>
                        <input type="password" name="Pass"></p>
                    <span style="display: block; margin-left: 116px; color: red">${pass}</span>
                </div>
                <div class="input">
                    <p><i class="fas fa-venus-mars" style="font-size: 25px; margin-top: 8px; margin-left: 6px;"></i>
                        <input type="radio" value="Male" checked name="gender" class="radio male">
                        <span class="text a">Male</span>
                        <input type="radio" value="Female" name="gender" class="radio female">
                        <span class="text b">Female</span>
                    </p>
                </div>
                <div class="input">
                    <p><i class="fas fa-calendar-alt" style="font-size: 25px; margin-top: 8px; margin-left: 6px;"></i>
                        <input type="date" name="Birth" style="width: 200px;margin-left: 61px;" value=""></p>
                    <span style="display: block; margin-left: 116px; color: red">${birth}</span>
                </div>
                <div class="input">
                    <p><i class="fas fa-phone" style="font-size: 25px; margin-top: 8px; margin-left: 3px;"></i>
                        <input type="text" name="Phone"></p>
                    <span style="display: block; margin-left: 116px; color: red">${phone}</span>
                </div>
                <div class="input">
                    <p><i class="fas fa-envelope" style="font-size: 25px; margin-top: 8px; margin-left: 6px;"></i>
                        <input type="text" name="Email"></p>
                    <span style="display: block; margin-left: 116px; color: red">${email}</span>
                </div>
                <div class="input">
                    <button type="submit">Đăng Ký</button>
                    <span style="display: block; margin-left: 116px; color: red">${mess}</span>
                </div>
                <a href="Login"><i class="fas fa-address-book" style="margin-left: 8px; margin-right: 7px"></i>Đăng Nhập</a>
            </form>
        </div>
    </body>
</html>
