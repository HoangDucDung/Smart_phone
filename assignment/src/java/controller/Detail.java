/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Models.Categorie;
import Models.Function;
import Models.Products;
import dal.CategorieDAO;
import dal.DetailDAO;
import dal.FunctionDao;
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

/**
 *
 * @author FPTSHOP
 */
@WebServlet(name = "Detail", urlPatterns = {"/Detail"})
public class Detail extends HttpServlet {

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
        //lấy list funtion 1
        ArrayList<Models.Detail> d = new DetailDAO().getDetailByPid(p.getProductId(), 1);
        getDetail(request, response);
        //lấy category
        ArrayList<Categorie> clist = new CategorieDAO().getCategoryByFid(1);
        // check xem là add hay edit nếu lấy list detail.size = 0 thì là add và ngược lại
        if(new DetailDAO().getDetailByPid(p.getProductId()).size() != 0){
            request.setAttribute("check", "Edit");
        } else {
            request.setAttribute("check", "Add");
        }
        request.setAttribute("clist", clist);
        request.setAttribute("product", p);
        request.setAttribute("detail1", d);
        RequestDispatcher dis = request.getRequestDispatcher("Detail.jsp");
        dis.forward(request, response);
    }
    private void getDetail(HttpServletRequest request, HttpServletResponse response){
        int pid = Integer.parseInt(request.getParameter("pid"));
        Models.Detail d2= new DetailDAO().getDetailByPidFid(pid, 2);
        Models.Detail d3= new DetailDAO().getDetailByPidFid(pid, 3);
        Models.Detail d4= new DetailDAO().getDetailByPidFid(pid, 4);
        request.setAttribute("detail2", d2);
        request.setAttribute("detail3", d3);
        request.setAttribute("detail4", d4);
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
        int pid = Integer.parseInt(request.getParameter("pid"));
        DetailDAO dao = new DetailDAO();
        //lấy category 1 là 1 aratlist
        ArrayList<Models.Detail> d = new DetailDAO().getDetailByPid(pid, 1);
        
        String list[] = {"Bảo mật vân tay","Nhận diện khuôn mặt","Chống nước & bụi","Sạc nhanh"};
        int count = 0;
        String mess = "";
        String check = request.getParameter("button");
        for (int i = 1; i <= 4; i++) {
            if(request.getParameter("tn"+i)!=null){
                count++;
            }
        }
        if(count==0) mess = "Bạn cần nhập đủ thông tin";
        if(request.getParameter("pin").equalsIgnoreCase("") || request.getParameter("inch").equalsIgnoreCase("") || request.getParameter("chip").equalsIgnoreCase("")){
            mess = "Bạn cần nhập đủ thông tin";
        }
        if(mess.equalsIgnoreCase("") && check.equalsIgnoreCase("Add")){
            for (int i = 1;i <= 4; i++) {
                if(request.getParameter("tn"+i)!=null){
                    dao.insertToDetail(pid, i, 1, list[i-1]);
                }
            }
            dao.insertToDetail(pid, Integer.parseInt(request.getParameter("PIN")), 2, request.getParameter("pin"));
            dao.insertToDetail(pid, Integer.parseInt(request.getParameter("INCH")), 3, request.getParameter("inch"));
            dao.insertToDetail(pid, Integer.parseInt(request.getParameter("CHIP")), 4, request.getParameter("chip"));
            response.sendRedirect("Manager");
        }
        if(mess.equalsIgnoreCase("") && check.equalsIgnoreCase("Edit")){
            for (int i = 1;i <= 4; i++) {
                //cứ = null là xóa kể cả k có trong table thì xóa cũng không thay đổi vì không tồn tại
                if(request.getParameter("tn"+i)==null){
                    dao.deleteDetail(pid, i, 1);
                } else if(request.getParameter("tn"+i)!=null){ //cứ != null là lại add 
                    dao.insertToDetail(pid, i, 1, list[i-1]);   //1: do trùng pk pid, cid, fid nên sẽ bị lỗi primary key nên sẽ k add được(đã có trong bảng)
                }                                               //2: nếu chưa tồn tại trong bảng thì add vào (chưa có trong bảng)
            }
            dao.iupdateDetail(pid, Integer.parseInt(request.getParameter("PIN")), 2, request.getParameter("pin"));
            dao.iupdateDetail(pid, Integer.parseInt(request.getParameter("INCH")), 3, request.getParameter("inch"));
            dao.iupdateDetail(pid, Integer.parseInt(request.getParameter("CHIP")), 4, request.getParameter("chip"));
            response.sendRedirect("Manager");
        }
        if(!mess.equalsIgnoreCase("")) processRequest(request, response);
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
