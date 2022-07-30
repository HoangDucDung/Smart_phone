/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.LoginDao;
import Models.Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author FPTSHOP
 */
@WebServlet(name = "SetAdmin", urlPatterns = {"/SetAdmin"})
public class SetAdmin extends HttpServlet {

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
        ArrayList<Login> llist = new LoginDao().getAllLogin();
        request.setAttribute("llist", llist);
        request.getRequestDispatcher("SetAdmin.jsp").forward(request, response);
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
        ArrayList<Login> llist = new LoginDao().getAllLogin();
        HttpSession session = request.getSession();
        Login l = (Login) session.getAttribute("Acc");
        
//        set dữ liệu theo input vào db
        for (Login login : llist) {
            if(request.getParameter(String.valueOf(login.getLoginID()))!=null){
                new LoginDao().setAdmin(login.getLoginID(), "1");
            } else {
                new LoginDao().setAdmin(login.getLoginID(), "0");
            }
        }
//        lấy lại dữ liêu sau khi đc update ở trên
        llist = new LoginDao().getAllLogin();
//        set lại session để có các chức năng của session vì session cũ vẫn lưu giá trị login cũ lên cần gán lại giá trị sau update
        for (Login login : llist) {
            if(l.getLoginID()==login.getLoginID() && l.getAdmin() != login.getAdmin()){
                l = login;
            }
        }
        System.out.println(l);
        session.setAttribute("Acc", l);
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
