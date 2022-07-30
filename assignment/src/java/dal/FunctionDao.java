/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import Models.Function;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author FPTSHOP
 */
public class FunctionDao extends DBcontext{
    public Function getAllFunction(int fid){
        try {
            String sql = "select * from [Function] where [FunctionId] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, fid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Function f = new Function(rs.getInt(1), rs.getString(2));
                return f;
            }
        } catch (Exception e) {
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(new FunctionDao().getAllFunction(1));
    }
}
