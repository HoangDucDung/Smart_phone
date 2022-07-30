/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import Models.Shippers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author FPTSHOP
 */
public class ShippersDAO extends DBcontext{
    public ArrayList<Shippers> getShippers(){
        ArrayList<Shippers> list = new ArrayList<>();
        try {
            String sql = "  select * from [Shippers]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Shippers sh = new Shippers(rs.getInt(1), rs.getString(2));
                list.add(sh);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(new ShippersDAO().getShippers());
    }
}
