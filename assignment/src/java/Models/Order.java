/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.time.LocalDate;

/**
 *
 * @author FPTSHOP
 */
public class Order {
    private int OrderId;
    private String CustomerName;
    private Login loginId;
    private Shippers shipperId;
    private String Address;
    private String Phone;
    private LocalDate Orderdate;
    private LocalDate ShippedDate;

    public Order() {
    }

    public Order(String CustomerName, Login loginId, Shippers shipperId, String Address, String Phone, LocalDate Orderdate, LocalDate ShippedDate) {
        this.CustomerName = CustomerName;
        this.loginId = loginId;
        this.shipperId = shipperId;
        this.Address = Address;
        this.Phone = Phone;
        this.Orderdate = Orderdate;
        this.ShippedDate = ShippedDate;
    }
    
    public Order(int OrderId, String CustomerName, Login loginId, Shippers shipperId, String Address, String Phone, LocalDate Orderdate, LocalDate ShippedDate) {
        this.OrderId = OrderId;
        this.CustomerName = CustomerName;
        this.loginId = loginId;
        this.shipperId = shipperId;
        this.Address = Address;
        this.Phone = Phone;
        this.Orderdate = Orderdate;
        this.ShippedDate = ShippedDate;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public Login getLoginId() {
        return loginId;
    }

    public void setLoginId(Login loginId) {
        this.loginId = loginId;
    }

    public Shippers getShipperId() {
        return shipperId;
    }

    public void setShipperId(Shippers shipperId) {
        this.shipperId = shipperId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public LocalDate getOrderdate() {
        return Orderdate;
    }

    public void setOrderdate(LocalDate Orderdate) {
        this.Orderdate = Orderdate;
    }

    public LocalDate getShippedDate() {
        return ShippedDate;
    }

    public void setShippedDate(LocalDate ShippedDate) {
        this.ShippedDate = ShippedDate;
    }

    @Override
    public String toString() {
        return "Order{" + "OrderId=" + OrderId + ", CustomerName=" + CustomerName + ", loginId=" + loginId + ", shipperId=" + shipperId + ", Address=" + Address + ", Phone=" + Phone + ", Orderdate=" + Orderdate + ", ShippedDate=" + ShippedDate + '}';
    }
    
    
}
