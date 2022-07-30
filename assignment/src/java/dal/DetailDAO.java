/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import Models.Detail;
import Models.Products;
import Models.Supplier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author FPTSHOP
 */
public class DetailDAO extends DBcontext{
    public void insertToDetail(int pid, int cid, int fid, String Description){
        try {
            String sql = "insert into Detail(ProductID,CategorieID, FunctionId, [Description]) values (?,?,?,N'"+Description+"')";
//            System.out.println(sql);
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            stm.setInt(2, cid);
            stm.setInt(3, fid);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }
    //lấy detail 
    public ArrayList<Detail> getDetailByPid(int pid, int fid){
        ArrayList<Detail> list = new ArrayList<>();
        try {
            String sql = "select * from [Detail] where [ProductID] = ? and FunctionId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            stm.setInt(2, fid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Detail d = new Detail(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getString(4));
                list.add(d);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public  Detail getDetailByPidFid(int pid, int fid){
        try {
            String sql = "select * from [Detail] where [ProductID] = ? and FunctionId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            stm.setInt(2, fid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Detail d = new Detail(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getString(4));
                return d;
            }
        } catch (Exception e) {
        }
        return null;
    }
    //hàm để check xem detail có tồn tại k
    public  ArrayList<Detail> getDetailByPid(int pid){
        ArrayList<Detail> list = new ArrayList<>();
        try {
            String sql = "select * from [Detail] where [ProductID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Detail d = new Detail(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getString(4));
                list.add(d);
            }
            } catch (Exception e) {
        }
        return list;
    }
    //hàm update
    public void iupdateDetail(int pid, int cid, int fid, String Description){
        try {
            String sql = "update [Detail] set CategorieID = ?, [Description] = ? where ProductID = ? and FunctionId = ?";
            System.out.println(sql);
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            stm.setString(2, Description);
            stm.setInt(3, pid);
            stm.setInt(4, fid);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }
    //hàm delete để áp dụng với fid = 1
    public void deleteDetail(int pid, int cid, int fid){
        try {
            String sql = "delete [Detail] where ProductID = ? and FunctionId = ? and CategorieID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            stm.setInt(2, fid);
            stm.setInt(3, cid);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    //hàm delete để áp dụng với productid khi mà muốn xóa product(FK)
    public void deleteDetailByPid(int pid){
        try {
            String sql = "delete [Detail] where ProductID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
//        System.out.println(new DetailDAO().iupdateDetail(1,7,2,"Trên 4000 mah"));
        new DetailDAO().iupdateDetail(1,7,2,"Trên 4000 mah");
    }
}
