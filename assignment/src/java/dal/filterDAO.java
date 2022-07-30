/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import Models.Products;
import Models.Supplier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author FPTSHOP
 */
public class filterDAO extends DBcontext{
    public ArrayList<Products> getSearch(String search){
        ArrayList<Products> list = new ArrayList<>();
        int count = 0;String Price = "";
        try {
            String sql = "  select p.*, s.SupplierName from [Products] p, Supplier s where p.SupplierId = s.SupplierId";
            if(!search.equalsIgnoreCase("")){
                sql += " and p.[ProductName] like ?";
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            if(!search.equalsIgnoreCase("")){
                stm.setString(1, "%"+search+"%");
            }
            System.out.println(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                int pri = rs.getInt("Price");
                count=0;Price = "";
//                System.out.println(pri);
                while(pri!=0){
                if(count%3==0 && count!=0){
                    Price = ","+Price;
                }
                Price = String.valueOf(pri%10)+Price;
                count++;
                pri = pri/10;
                }  
                Products p = new Products(rs.getInt(1), rs.getString(2), 
                                            new Supplier(rs.getString("SupplierName")), 
                                            rs.getInt(4), Price, rs.getString(6));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(new filterDAO().getSearch("ip"));
    }
}
