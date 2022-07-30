/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import Models.OrderDetail;
import Models.Products;
import java.sql.PreparedStatement;

/**
 *
 * @author FPTSHOP
 */
public class OrderDetailDAO extends DBcontext{
    public void insertOrderDetail(OrderDetail ord){
        try {
            String sql = "  insert into Orderdetail (OrderID,ProductID,Quantity,Price) values (?, ?, ?, ?)";
            Products p =new ProductsDao().getProductBypId(ord.getProductId());
            new ProductsDao().updateQuantity(ord.getProductId(), p.getQuantity()-ord.getQuantity());
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, ord.getOrderId());
            stm.setInt(2, ord.getProductId());
            stm.setInt(3, ord.getQuantity());
            stm.setString(4, ord.getPrice());
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }
    // xóa orderdetail để có thể xóa products
    public void deleteOrderDetail(int pid){
        try {
            String sql = "delete from Orderdetail where [ProductID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }
}
