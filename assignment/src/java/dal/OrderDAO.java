/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import Models.Order;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author FPTSHOP
 */
public class OrderDAO extends DBcontext{
    public int insertToOrder(Order od){
        try {
            String sql = "insert into [Order] (CustomerName, LoginID, shipperID, [Address], Phone, Orderdate, ShippedDate) "
                    + "values (N'"+od.getCustomerName()+"', ?, ?, N'"+od.getAddress()+"', ?, ?, ?)";
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, od.getLoginId().getLoginID());
            stm.setInt(2, od.getShipperId().getShipperID());
            stm.setString(3, od.getPhone());
            stm.setDate(4, Date.valueOf(od.getOrderdate()));
            stm.setDate(5, Date.valueOf(od.getShippedDate()));
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
}
