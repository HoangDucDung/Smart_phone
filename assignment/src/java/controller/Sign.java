/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.LoginDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FPTSHOP
 */
@WebServlet(name = "Sign", urlPatterns = {"/Sign"})
public class Sign extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dis = request.getRequestDispatcher("Sign.jsp");
        dis.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean check = true;
        String mess = "";
        String User = request.getParameter("User"); String alertU = "";
        String Pass = request.getParameter("Pass"); String alertP = "";
        String Gender = request.getParameter("gender");
        LocalDate Birth = LocalDate.now(); String alertB = "";
        if(!request.getParameter("Birth").equalsIgnoreCase("")){
            Birth = LocalDate.parse(request.getParameter("Birth")); 
        }
        String Phone = request.getParameter("Phone");String alertPh = "";
        String Email = request.getParameter("Email"); String alertE = "";
        // check User
        if(!new LoginDao().checkUser(User)){
            alertU = "User đã tồn tại";
            check = false;
        } else if(User.equalsIgnoreCase("")){
            alertU = "Vui lòng nhập User!";
            check = false;
        }
        // check Pass
        if(Pass.length()<5){
            alertP = "Độ dài Pass trên 5 ký tự";
            check = false;
        }
        // check Birth
        if(Birth.isEqual(LocalDate.now())){
            alertB = "Vui lòng nhập Birth";
            check = false;
        }
        // check Phone
        if(!request.getParameter("Phone").matches("^\\d{10}$")){
            alertPh = "Độ dài Phone 10 và là số";
            check = false;
        }
        // check Email
        if(!Email.matches("^\\w+@\\w+.\\w+$")){
            alertE = "Nhập đúng định dạng 910J@JQK.QKA";
            check = false;
        }
        System.out.println(check);
        if(check){
            System.out.println(new Models.Login(User, Pass, Gender, Birth, Phone, Email));
            new LoginDao().insertLogin(new Models.Login(User, Pass, Gender, Birth, Phone, Email));
            mess = "Thêm thành công";
        }
        
        request.setAttribute("mess", mess);
        request.setAttribute("user", alertU);
        request.setAttribute("pass", alertP);
        request.setAttribute("birth", alertB);
        request.setAttribute("phone", alertPh);
        request.setAttribute("email", alertE);
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
