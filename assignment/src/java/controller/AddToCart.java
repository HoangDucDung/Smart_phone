/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Models.Products;
import Models.Login;
import dal.ProductsDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class AddToCart extends HttpServlet {

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
        HttpSession session = request.getSession();
        //nếu k có ng đăng nhập mà muốn addtocarrt thì respone trang login
        if(session.getAttribute("Acc")==null){
            response.sendRedirect("Login");
        } else{
            Login l = (Login) session.getAttribute("Acc");
            int pid = Integer.parseInt(request.getParameter("pid"));
            ArrayList<Products> plist = new ArrayList<>();
            Products p = new ProductsDao().getProductBypId(pid);
            Products p2 = new ProductsDao().getProductBypId(pid);
            p.setQuantity(1);
            if(session.getAttribute("Cart"+l.getUser())!=null){
                plist = (ArrayList<Products>) session.getAttribute("Cart"+l.getUser());
            } 
            //biến check rằng nếu k có có productid đã tồn tại thì false còn 
            //nếu có thì set quantity tăng lên 1 và đổi check bằng true tương ứng với product đã tồn tại p thì k add nữa.
            boolean check = false;
            //set quantity theo số lượng người dùng bấm addtocart
            for (Products products : plist) {
                if(p.getProductId() == products.getProductId() ){
                    if(products.getQuantity() < p2.getQuantity()){
                        products.setPrice(new ProductsDao().convertPrice(products.getPrice(), products.getQuantity(),true));
                        products.setQuantity((products.getQuantity()+1));
                    }
                    check = true;
                } 
            }
            if(plist.size()==0 || check == false) plist.add(p);
            //set session cho từng user dựa trên kết hợp tên user và trả về 1 list cart và 1 size của cart của từng đối tượng
            session.setAttribute("Cart"+l.getUser(), plist);// gán Cart + tên user đang đăng nhập = plist
            session.setAttribute("sizecart"+l.getUser(), plist.size());// gán sizecart + tên ueser = plist.size()
            
            String URL = session.getAttribute("URL").toString();
            response.sendRedirect(URL);
        }
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
