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
public class SupplierDAO extends DBcontext{
    public ArrayList<Supplier> getAllSupplier(){
        ArrayList<Supplier> list = new ArrayList<>();
        try {
            String sql = "  select * from Supplier s";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Supplier s = new Supplier(rs.getInt(1), rs.getString(2));
                list.add(s);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(new SupplierDAO().getAllSupplier());
    }
}
