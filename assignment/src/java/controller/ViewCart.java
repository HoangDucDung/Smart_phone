/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Models.Login;
import Models.Products;
import dal.ProductsDao;
import java.util.ArrayList;

/**
 *
 * @author FPTSHOP
 */
@WebServlet(name = "ViewCart", urlPatterns = {"/ViewCart"})
public class ViewCart extends HttpServlet {

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
        Login l = (Login) session.getAttribute("Acc");
        ArrayList<Products> plist = new ArrayList<>();
        if (l == null) {
            response.sendRedirect("Login");
        } else {
            if (session.getAttribute("Cart" + l.getUser()) != null) {
                plist = (ArrayList<Products>) session.getAttribute("Cart" + l.getUser());
            }
            //xóa product trong cart 
            if (request.getParameter("pid") != null) {
                int pid = Integer.parseInt(request.getParameter("pid"));
                for (int i = 0; i < plist.size(); i++) {
                    if (pid == plist.get(i).getProductId()) {
                        if ((plist.get(i).getQuantity() - 1) == 0 || request.getParameter("del")!=null) {
                            plist.remove(i);
                        } else {
                            //set lai price bang ham chuyen doi price trong ProductsDAO
                            plist.get(i).setPrice(new ProductsDao().convertPrice(plist.get(i).getPrice(), plist.get(i).getQuantity(), false));
                            //giam quantity neu giam == 0 thi quay laij dong 54 55
                            plist.get(i).setQuantity((plist.get(i).getQuantity() - 1));
                        }
                    }
                }
                session.setAttribute("Cart" + l.getUser(), plist);
                session.setAttribute("sizecart" + l.getUser(), plist.size());
                response.sendRedirect("ViewCart");
            } else {
                //do nếu chưa ấn addtocart thì session Cart+user = null vì để tránh null khi bấm viewcart thì khi bấm viewcart sẽ
                //set Cart = plist (lần đâu plisst là []) thì sẽ k bị null nữa
                session.setAttribute("Cart" + l.getUser(), plist);
                session.setAttribute("sizecart" + l.getUser(), plist.size());
                request.getRequestDispatcher("ViewCart.jsp").forward(request, response);
            }
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
        HttpSession session = request.getSession();
        String a = "";
        if(session.getAttribute("mess") != null){
            a = session.getAttribute("mess").toString();
        }
        request.setAttribute("mess", a);
        session.removeAttribute("mess");
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
