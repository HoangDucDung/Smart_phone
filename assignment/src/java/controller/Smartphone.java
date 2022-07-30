/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Models.Products;
import dal.ProductsDao;
import dal.filterDAO;
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
@WebServlet(name = "Smartphone", urlPatterns = {"/Smartphone"})
public class Smartphone extends HttpServlet {

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
        getListProduct(request, response);
        HttpSession session = request.getSession();
        Models.Login l = (Models.Login)session.getAttribute("Acc");
        request.setAttribute("Acc", l);
        //sử lý lấy được size của session dựa vào user đăng nhập
        if(l!=null){
//          nếu user đc đăng nhập thì 2 đk 1 là xem size ở session nếu rỗng thì gán = 0 nếu k thì gán bằng sizecart 
//          vì mặc định ở AddToCart sizecart = list.size() danh sách sản phẩm trong cart
            if(session.getAttribute("sizecart"+l.getUser())==null){
                request.setAttribute("sizecart", 0);
            } else {
                request.setAttribute("sizecart", session.getAttribute("sizecart"+l.getUser()));
            }
        } else {//nếu user k đc đăng nhập thì sizecart = 0
            request.setAttribute("sizecart", 0);
        }
        RequestDispatcher dis = request.getRequestDispatcher("Smartphone.jsp");
        dis.forward(request, response);
    }
    private void getListProduct(HttpServletRequest request, HttpServletResponse response){
        int page = 1;
        int sid = 0; int cid = 0;
        if(request.getParameter("sid")!=null){
            sid = Integer.parseInt(request.getParameter("sid"));
        }
        if(request.getParameter("cid")!=null){
            cid = Integer.parseInt(request.getParameter("cid"));
        }
        int totalpageProduct = new ProductsDao().getSizeProduct(sid,cid);
//        System.out.println(totalpageProduct);
        int totalpage = totalpageProduct/12;
        if(totalpageProduct/12 != 0 ) totalpage += 1;
        if(request.getParameter("page")!=null){
            page = Integer.parseInt(request.getParameter("page"));
        }
        int offSet = (page-1)*12;
        ArrayList<Products> list = new ProductsDao().getAllProductPage(sid,offSet);
        if(cid!=0){
            list = new ProductsDao().getAllProductPageCid(cid, offSet);
        }
        request.setAttribute("page", page);
        request.setAttribute("sid", sid);
        request.setAttribute("totalpage", totalpage);
        if(request.getParameter("search")==null || request.getParameter("search").equalsIgnoreCase("")){
        request.setAttribute("plist", list);
        }
//        System.out.println(list);
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
        ArrayList<Products> plist = new filterDAO().getSearch("");
        if(request.getParameter("search")!=null){
            plist = new filterDAO().getSearch(request.getParameter("search"));
        }
        request.setAttribute("search", request.getParameter("search"));
        request.setAttribute("plist", plist);
        processRequest(request, response);
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
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
