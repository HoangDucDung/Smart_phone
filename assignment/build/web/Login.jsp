<%-- 
    Document   : Login
    Created on : Feb 28, 2022, 2:04:55 PM
    Author     : FPTSHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <style>
        body{
            display: flex;
            width: 99vw;
            height: 97vh;
            background-color: #cfcfcf;
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
            width: 393px;
            height: 400px;
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
            width: 242px;
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
    </style>
    </head>
    <body>
        <div class="bodylogin">
            <form action="Login" method="post">
                <h2>User Login</h2>
                <div class="input">
                    <p><i class="fas fa-address-book" style="font-size: 25px; margin-top: 8px; margin-left: 6px;"></i><input type="text" name="User" value="${user}"></p>
                </div>
                <div class="input">
                    <p><i class="fas fa-lock" style="font-size: 25px; margin-top: 8px; margin-left: 6px;"></i></i><input type="password" name="Pass"></p>
                    <span style="display: block; margin-left: 52px; color: red">${mess}</span>
                </div>
                <div class="input">
                    <button type="submit" style="cursor: pointer" value="login" name="login">Đăng Nhập</button>
                </div>
                <div class="input">
                    <button type="submit" style="cursor: pointer" value="sign" name="login">Đăng Ký</button>
                </div>
            </form>
        </div>
    </body>
</html>
