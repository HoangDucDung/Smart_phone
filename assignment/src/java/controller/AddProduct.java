/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Models.Products;
import Models.Supplier;
import dal.ProductsDao;
import dal.SupplierDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
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
@WebServlet(name = "AddProduct", urlPatterns = {"/AddProduct"})
public class AddProduct extends HttpServlet {

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
        ArrayList<Supplier> list = new SupplierDAO().getAllSupplier();
        request.setAttribute("supplier", list);
        RequestDispatcher dis = request.getRequestDispatcher("AddProduct.jsp");
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
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("pname");
        ArrayList<Products> pl = new ProductsDao().getAllProduct();
        int supplierId = Integer.parseInt(request.getParameter("psub"));
        int quantity = 0;
        if(!request.getParameter("pquan").equalsIgnoreCase("")){
            quantity = Integer.parseInt(request.getParameter("pquan"));
        }
        String price = request.getParameter("pprice");
        String img = request.getParameter("pimg");
        String mess = "";
        if(!price.matches("^\\d{1,9}$")){
            mess = "lỗi nhập Price";
        }
        for (Products products : pl) {
            if(products.getProductName().equalsIgnoreCase(name)){
                if(!mess.equalsIgnoreCase("")){
                    mess +=" và ";
                }
                mess += "sản phẩm đã tồn tại";
            }
        }
        if(mess.equalsIgnoreCase("")){
            Products p = new Products(name, new Supplier(supplierId), quantity, price, img);
            int pid = new ProductsDao().insertProduct(p);
            response.sendRedirect("Detail?pid="+pid);
        } else {
            request.setAttribute("name", name);
            request.setAttribute("quantity", quantity);
            request.setAttribute("price", price);
            request.setAttribute("img", img);
            request.setAttribute("mess", mess);
            processRequest(request, response);
        }
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
