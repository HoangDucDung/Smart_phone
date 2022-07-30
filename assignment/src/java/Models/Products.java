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
public class Products {
    private int ProductId;
    private String ProductName;
    Supplier supplier; 
    private int Quantity;
    private String Price;
    private String img;
    
    public Products() {
    }

    public Products(int ProductId, String ProductName, Supplier supplier, int Quantity, String Price, String img) {
        this.ProductId = ProductId;
        this.ProductName = ProductName;
        this.supplier = supplier;
        this.Quantity = Quantity;
        this.Price = Price;
        this.img = img;
    }
    
    public Products(String ProductName, Supplier supplier, int Quantity, String Price, String img) {
        this.ProductName = ProductName;
        this.supplier = supplier;
        this.Quantity = Quantity;
        this.Price = Price;
        this.img = img;
    }
    
    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    
    @Override
    public String toString() {
        return "Products{" + "ProductId=" + ProductId + ", ProductName=" + ProductName + ", supplier=" + supplier + ", Quantity=" + Quantity + ", Price=" + Price + ", img=" + img + '}';
    }
    
}
