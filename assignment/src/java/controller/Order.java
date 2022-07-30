/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Models.*;
import dal.OrderDAO;
import dal.OrderDetailDAO;
import dal.ProductsDao;
import dal.ShippersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
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
@WebServlet(name = "Order", urlPatterns = {"/Order"})
public class Order extends HttpServlet {

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
        ArrayList<Shippers> slist = new ShippersDAO().getShippers();
        HttpSession session = request.getSession();
        if(session.getAttribute("Acc")==null){
            response.sendRedirect("Login");
        }else{
            Models.Login l = (Models.Login)session.getAttribute("Acc");
            //ngại viết chuyển đổi session thành arraylist nên chuyển thành string so sánh với:    [] <--> chuỗi rỗng
            if(session.getAttribute("Cart"+l.getUser()).toString().equalsIgnoreCase("[]")){
                response.sendRedirect("ViewCart");
            }else{
                request.setAttribute("slist", slist);
                totalProduct(request, response);
                request.getRequestDispatcher("Order.jsp").forward(request, response);
            }
        }
        
    }
    private void totalProduct(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Models.Login l = (Models.Login) session.getAttribute("Acc");
        ArrayList<Products> plist = (ArrayList<Products>) session.getAttribute("Cart"+l.getUser());
        
        int totalQuan = 0; int totalPri = 0;
        for (Products products : plist) {
            totalQuan += products.getQuantity();
            totalPri += convert(products.getPrice());
        }
        request.setAttribute("cartlist", plist);
        request.setAttribute("totalQuan", totalQuan);
        request.setAttribute("totalprice", convertStr(totalPri));
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
    private  String convertStr(int price){
        int count = 0;String p = "";
        while(price!=0){
                if(count%3==0 && count!=0){
                    p = ","+p;
                }
                p = String.valueOf(price%10)+p;
                count++;
                price = price/10;
                }  
        return p;
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
        HttpSession session = request.getSession();
        String Name = request.getParameter("Name");
        int shipper = Integer.parseInt(request.getParameter("shipper"));
        Models.Login l = (Models.Login)session.getAttribute("Acc");
        String Address = request.getParameter("Address");
        String Phone = request.getParameter("Phone");
        LocalDate orderdate = LocalDate.now();
        LocalDate shippeddate = LocalDate.now().plusDays(7);
        
        String warmP = ""; String mess = "";
        //đk phone
        if(!Phone.matches("^\\d{10}$")){
            warmP = "Độ dài Phone 10 và là số";
        }
        if(Name.equalsIgnoreCase("") || Address.equalsIgnoreCase("") || Phone.equalsIgnoreCase("")){
            mess = "Cần nhập đủ thông tin";
        }
        if(mess.equalsIgnoreCase("") && warmP.equalsIgnoreCase("")){
            Models.Order o = new Models.Order (Name,l, new Shippers(shipper), Address, Phone, orderdate, shippeddate);
            ArrayList<Products> plist = (ArrayList<Products>) session.getAttribute("Cart"+l.getUser());
            ArrayList<OrderDetail> odtlist = new ArrayList<>();
            for (Products products : plist) {
                odtlist.add(new OrderDetail(0, products.getProductId(), products.getQuantity(), products.getPrice()));
            }
            logicOrder(o, odtlist);
            mess = "Ngày đặt: "+orderdate+" ==> ngày nhận: "+shippeddate;
            //làm mới giỏ hàng của người dùng
            session.setAttribute("Cart"+l.getUser(),new ArrayList<Products>());
            //truyền thông tin add thành công với ngày đặt ngày nhận sẽ hiển thị ở viewcart theo đk 30 - 35 
            session.setAttribute("mess", mess);
        }
        request.setAttribute("warmP", warmP);
        request.setAttribute("mess", mess);
        processRequest(request, response);
    }
    
    private void logicOrder(Models.Order order, ArrayList<OrderDetail> list){
        int orderId = new OrderDAO().insertToOrder(order);
        for (OrderDetail orderDetail : list) {
            orderDetail.setOrderId(orderId);
            new OrderDetailDAO().insertOrderDetail(orderDetail);
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
