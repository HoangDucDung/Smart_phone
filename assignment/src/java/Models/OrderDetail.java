/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author FPTSHOP
 */
public class OrderDetail {
    private int OrderId;
    private int ProductId;
    private int Quantity;
    private String Price;

    public OrderDetail() {
    }

    public OrderDetail(int OrderId, int ProductId, int Quantity, String Price) {
        this.OrderId = OrderId;
        this.ProductId = ProductId;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "OrderId=" + OrderId + ", ProductId=" + ProductId + ", Quantity=" + Quantity + ", Price=" + Price + '}';
    }
    
}
