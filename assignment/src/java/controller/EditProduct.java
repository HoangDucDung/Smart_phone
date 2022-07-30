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
@WebServlet(name = "EditProduct", urlPatterns = {"/EditProduct"})
public class EditProduct extends HttpServlet {

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
        Products p = new ProductsDao().getProductBypId(Integer.parseInt(request.getParameter("pid")));
        ArrayList<Supplier> list = new SupplierDAO().getAllSupplier();
        p.setPrice(String.valueOf(convert(p.getPrice())));
        request.setAttribute("supplier", list);
        request.setAttribute("product", p);
        RequestDispatcher dis = request.getRequestDispatcher("EditProducts.jsp");
        dis.forward(request, response);
    }
    
    private  int convert(String price){
        String a[] = price.split(",");
        price = "";
        for (int i = 0; i < a.length; i++) {
            price = price+""+a[i];
        }
        int c = Integer.valueOf(price);
        return c;
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
        int id = Integer.parseInt(request.getParameter("pid"));
        String name = request.getParameter("pName");
        int supplierId = Integer.parseInt(request.getParameter("pSup"));
        int quantity = Integer.parseInt(request.getParameter("pQuan"));
        String price = request.getParameter("pPrice");
        String img = request.getParameter("pImg");
        String mess = "";
        if(!price.matches("^\\d{1,9}$")){
            mess = "loi nhap price";
        }else{
            Products p = new Products(id, name, new Supplier(supplierId), quantity, price, img);
            new ProductsDao().updateProduct(p);
            mess = "edit thanh cong";
        }
        request.setAttribute("mess", mess);
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
