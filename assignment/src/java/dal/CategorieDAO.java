/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import Models.Categorie;
import Models.Function;
import Models.Products;
import Models.Supplier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author FPTSHOP
 */
public class CategorieDAO extends DBcontext{
    public ArrayList<Categorie> getCategoryByFid(int fid){
        ArrayList<Categorie> list = new ArrayList<>();
        try {
            String sql = "  select * from Categories where [FunctionId] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, fid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Categorie c = new Categorie(rs.getInt(1), new Function(rs.getInt(2)), rs.getString(3));
                list.add(c);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(new CategorieDAO().getCategoryByFid(1));
    }
}
