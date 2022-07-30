/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Models.Products;
import dal.DetailDAO;
import dal.ProductsDao;
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
@WebServlet(name = "DetailProduct", urlPatterns = {"/DetailProduct"})
public class DetailProduct extends HttpServlet {

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
        getProductSession(request, response);
        getDetailByPid(request, response);
        request.setAttribute("product", p);
        RequestDispatcher dis = request.getRequestDispatcher("DetailProduct.jsp");
        dis.forward(request, response);
    }
    //các sản phẩm mới xem
    private void getProductSession(HttpServletRequest request, HttpServletResponse response){
        Products p = new ProductsDao().getProductBypId(Integer.parseInt(request.getParameter("pid")));
        ArrayList<Products> plist = new ArrayList<>();
        HttpSession session = request.getSession();
        if(session.getAttribute("productlist")!=null){
            plist = (ArrayList<Products>)session.getAttribute("productlist");
        }
        int count = 0;
        for (int i = 0; i < plist.size(); i++) {
            if(count == 7 && plist.get(i).getProductId()!=p.getProductId()){
                plist.remove(plist.get(0));
            }
            if(plist.get(i).getProductId()==p.getProductId()){
                plist.remove(plist.get(i));
            }
            count++;
        }
        plist.add(p);
//        System.out.println(session.getAttribute("productlist"));
        session.setAttribute("productlist", plist);
//        System.out.println("sesion: "+session.getAttribute("productlist"));
    }
    
    private void getDetailByPid(HttpServletRequest request, HttpServletResponse response){
        int pid = Integer.parseInt(request.getParameter("pid"));
        ArrayList<Models.Detail> tn = new DetailDAO().getDetailByPid(pid, 1);
        Models.Detail pin = new DetailDAO().getDetailByPidFid(pid, 2);
        Models.Detail inch = new DetailDAO().getDetailByPidFid(pid, 3);
        Models.Detail chip = new DetailDAO().getDetailByPidFid(pid, 4);
        request.setAttribute("tn", tn);
        request.setAttribute("pin", pin);
        request.setAttribute("inch", inch);
        request.setAttribute("chip", chip);
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
