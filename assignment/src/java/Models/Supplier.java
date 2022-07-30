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
public class Supplier {
    private int SupplierId;
    private String SupplierName;

    public Supplier() {
    }

    public Supplier(int SupplierId, String SupplierName) {
        this.SupplierId = SupplierId;
        this.SupplierName = SupplierName;
    }

    public Supplier(int SupplierId) {
        this.SupplierId = SupplierId;
    }
    
    public Supplier(String SupplierName) {
        this.SupplierName = SupplierName;
    }
    
    public int getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(int SupplierId) {
        this.SupplierId = SupplierId;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String SupplierName) {
        this.SupplierName = SupplierName;
    }

    @Override
    public String toString() {
        return "Supplier{" + "SupplierId=" + SupplierId + ", SupplierName=" + SupplierName + '}';
    }
    
}
