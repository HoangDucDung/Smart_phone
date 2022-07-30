/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import Models.Login;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author FPTSHOP
 */
public class LoginDao extends DBcontext{
    // hàm check user tồn tại hay chưa để tránh trùng lạp user
    public boolean checkUser(String User){
        try {
            String sql = "select * from [Login] where [User] like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, User);
            ResultSet rs = stm.executeQuery();
            if(rs.next()==true) return false;
        } catch (Exception e) {
        }
        return true;
    }
    //hàm login trả về 1 đối tượng login nếu user, pass đúng với giá trị nhập vào
    public Login loginAcc(String User, String Pass){
        try {
            String sql = "select * from [Login] where [User] like ? and [Pass] like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, User);
            stm.setString(2, Pass);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Login lo = new Login(   rs.getInt(1), rs.getString(2), 
                                        rs.getString(3), rs.getString(4), 
                                        rs.getDate(5).toLocalDate(), rs.getString(6), 
                                        rs.getString(7), rs.getInt(8));
                return lo;
            }
        } catch (Exception e) {
        }
        return null;
    }
    //hàm lấy dữ liệu by loginid
    public Login getLoginByID(int Lid){
        try {
            String sql = "  select * from [Login] where [LoginID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, Lid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Login lo = new Login(   rs.getInt(1), rs.getString(2), 
                                        rs.getString(3), rs.getString(4), 
                                        rs.getDate(5).toLocalDate(), rs.getString(6), 
                                        rs.getString(7), rs.getInt(8));
                return lo;
            }
        } catch (Exception e) {
        }
        return null;
    }
    //hàm thêm dữ liệu vào bảng login
    public void insertLogin(Login user){
        try {
            String sql = "insert into [Login] (\"User\",\"Pass\",\"Gender\",\"Birth\",\"Phone\",\"Email\",\"Admin\") "
                    + "values (?,?,?,?,?,?,0)";
//            System.out.println(sql);
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user.getUser());
            stm.setString(2, user.getPass());
            stm.setString(3, user.getGender());
            stm.setDate(4, Date.valueOf(user.getBirth()));
            stm.setString(5, user.getPhone());
            stm.setString(6, user.getEmail());
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }
    //hàm lấy toàn bộ giữ liệu
    public ArrayList<Login> getAllLogin(){
        ArrayList<Login> list = new ArrayList<>();
        try {
            String sql = "select * from [Login]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Login lo = new Login(   rs.getInt(1), rs.getString(2), 
                                        rs.getString(3), rs.getString(4), 
                                        rs.getDate(5).toLocalDate(), rs.getString(6), 
                                        rs.getString(7), rs.getInt(8));
                list.add(lo);
            }
        } catch (Exception e) {
        }
        return list;
    }
    //hàm update admin
    public void setAdmin(int Lid, String value){
        try {
            String sql = "update Login set [Admin] = 1 where [LoginID] = ?";
            if(value.equalsIgnoreCase("0")){
                sql = "update Login set [Admin] = 0 where [LoginID] = ?";
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, Lid);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        System.out.println(new LoginDao().loginAcc("NguyenVanA", "jqk"));
    }
}
