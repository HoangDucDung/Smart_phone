/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import Models.Products;
import Models.Supplier;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FPTSHOP
 */
public class ProductsDao extends DBcontext{
    //hàm lấy toàn bộ product
    public ArrayList<Products> getAllProduct(){
        ArrayList<Products> list = new ArrayList<>();
        int count = 0;String Price = "";
        try {
            String sql = "  select p.*, s.SupplierName from [Products] p, Supplier s where p.SupplierId = s.SupplierId";
            PreparedStatement stm = connection.prepareStatement(sql);
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
    //hàm lấy product thông qua id
    public Products getProductBypId(int pid){
        Products p = new Products();
        int count = 0;String Price = "";
        try {
            String sql = "  select p.*, s.SupplierName from [Products] p, Supplier s "
                        + "where p.SupplierId = s.SupplierId and p.[ProductID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                int pri = rs.getInt("Price");
                count=0;Price = "";
                while(pri!=0){
                if(count%3==0 && count!=0){
                    Price = ","+Price;
                }
                Price = String.valueOf(pri%10)+Price;
                count++;
                pri = pri/10;
                }  
                p = new Products(rs.getInt(1), rs.getString(2), 
                                            new Supplier(rs.getInt("SupplierId"),rs.getString("SupplierName")), 
                                            rs.getInt(4), Price, rs.getString(6));
            }
        } catch (Exception e) {
        }
        return p;
    }
    //hàm thêm thông tin product vào bảng và trả về id để có thể in sert detail
    public int insertProduct(Products p){
        try{
            String sql = "insert into Products(ProductName,SupplierId,Quantity,Price,img)"
                    + " values (N'"+ p.getProductName()+"',?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println(sql);
            stm.setInt(1, p.getSupplier().getSupplierId());
            stm.setInt(2, p.getQuantity());
            stm.setInt(3,Integer.parseInt(p.getPrice()));
            stm.setString(4, p.getImg());
            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next())
            {
                int productId = Integer.parseInt(rs.getString(1));
                return productId;
            }
        }
        catch(Exception ex){
        }
        return -1;
    }
    //hàm edit
    public void updateProduct(Products p){
        try {
            String sql = "  update Products set ProductName = ?, SupplierId = ?, Quantity = ?, Price = ?, img = ? where ProductID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, p.getProductName());
            stm.setInt(2, p.getSupplier().getSupplierId());
            stm.setInt(3, p.getQuantity());
            stm.setInt(4, Integer.valueOf(p.getPrice()));
            stm.setString(5, p.getImg());
            stm.setInt(6, p.getProductId());
            stm.executeUpdate();
        } catch (Exception e) {
        }     
    }
    //hàm gọi product theo page
    public ArrayList<Products> getAllProductPage(int sid, int offset){
        ArrayList<Products> list = new ArrayList<>();
        int count = 0;String Price = "";
        try {
            String sql = "select * from [Products] where [SupplierId] = ? order by [ProductID] offset ? rows fetch next 12 rows only";
            if(sid == 0){
                sql = "select * from [Products] order by [Price] DESC offset ? rows fetch next 12 rows only";
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            if(sid == 0){
                stm.setInt(1, offset);
            } else{
                stm.setInt(1, sid);
                stm.setInt(2, offset);
            }
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
                Products p = new Products(rs.getInt("ProductID"), 
                                            rs.getString("ProductName"), 
                                            new Supplier(rs.getInt("SupplierId")), 
                                            rs.getInt("Quantity"), Price, rs.getString("img"));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<Products> getAllProductPageCid(int cid, int offset){
        ArrayList<Products> list = new ArrayList<>();
        int count = 0;String Price = "";
        try {
            String sql = "select p.*, s.SupplierId  from Detail d, Products p, Supplier s where p.ProductID = d.ProductID "
                    + "and s.SupplierId = p.SupplierId  and d.CategorieID = ? order by [ProductID] offset ? rows fetch next 12 rows only";
            if(cid == 0){
                sql = "select * from [Products] order by [Price] DESC offset ? rows fetch next 12 rows only";
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            if(cid == 0){
                stm.setInt(1, offset);
            } else{
                stm.setInt(1, cid);
                stm.setInt(2, offset);
            }
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
                Products p = new Products(rs.getInt("ProductID"), 
                                            rs.getString("ProductName"), 
                                            new Supplier(rs.getInt("SupplierId")), 
                                            rs.getInt("Quantity"), Price, rs.getString("img"));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }
    //hàm lấy size
    public int getSizeProduct(int sid, int cid){
        String sql = "select COUNT(*) [count] from [Products] where [SupplierId] = ?";
        if(sid ==0 && cid == 0){
            sql = "select COUNT(*) [count] from [Products]";
        } 
        if(cid != 0){
            sql = "select COUNT(*) [count] from  Detail d where  d.CategorieID = ?";
        }
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            if(sid!=0)stm.setInt(1, sid);
            if(cid!=0)stm.setInt(1, cid);
            ResultSet rs = stm.executeQuery();
            rs.next();
            return rs.getInt("count");
        } catch (Exception e) {
        }
        return 0;
    }
    
    //hàm chuyển đổi price
    public String convertPrice(String price, int number, boolean check){
        String a[] = price.split(",");
        price = ""; int c = 0;
        for (int i = 0; i < a.length; i++) {
            price = price+""+a[i];
        }
        if(check == true){
            c = Integer.valueOf(price) + (Integer.valueOf(price)/number);
        } else{
            c = Integer.valueOf(price) - (Integer.valueOf(price)/number);
        }
        int count = 0;String p = "";
        while(c!=0){
                if(count%3==0 && count!=0){
                    p = ","+p;
                }
                p = String.valueOf(c%10)+p;
                count++;
                c = c/10;
                }  
        return p;
    }
    
    //hàm xóa product
    public void deleteProducts(int pid){
        try {
            String sql = "  delete from [Products] where ProductID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            new OrderDetailDAO().deleteOrderDetail(pid);
            new DetailDAO().deleteDetailByPid(pid);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    //hàm update quantity sau khi mua
    public void updateQuantity(int pid, int quantity){
        try {
            String sql = "update [Products] set Quantity = ? where ProductID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quantity);
            stm.setInt(2, pid);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }
    //hàm lấy product by category
    public ArrayList<Products> getProductByCid(ArrayList<Integer> cid){
        ArrayList<Products> list = new ArrayList<>();
        int count = 0;String Price = "";
        try {
            String sql = "select p.*, s.SupplierId  from Detail d, Products p, Supplier s where p.ProductID = d.ProductID and s.SupplierId = p.SupplierId ";
            if(cid.size()!=0){
                sql += " and ";
                for (int i = 0; i < cid.size(); i++) {
                    if(i==cid.size()-1){
                    sql += " d.CategorieID = ? ";} else{
                        sql += " d.CategorieID = ? or";
                    }
                }
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            System.out.println(sql);
            if(cid.size()!=0){
                for (int i = 0; i < cid.size(); i++) {
                    stm.setInt(1, cid.get(i));
                }
            }
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
                Products p = new Products(rs.getInt("ProductID"), 
                                            rs.getString("ProductName"), 
                                            new Supplier(rs.getInt("SupplierId")), 
                                            rs.getInt("Quantity"), Price, rs.getString("img"));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }
//    public static void main(String[] args) {
//        ArrayList<Integer> cid = new ArrayList<>();
//        cid.add(3);
//        cid.add(2);
//        System.out.println(new ProductsDao().getSizeProduct(0,0));
//    }
}
