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
public class Shippers {
    private int shipperId;
    private String shipperName;

    public Shippers() {
    }

    public Shippers(int shipperId) {
        this.shipperId = shipperId;
    }
    
    public Shippers(int shipperID, String shipperName) {
        this.shipperId = shipperID;
        this.shipperName = shipperName;
    }

    public int getShipperID() {
        return shipperId;
    }

    public void setShipperID(int shipperID) {
        this.shipperId = shipperID;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    @Override
    public String toString() {
        return "Shippers{" + "shipperID=" + shipperId + ", shipperName=" + shipperName + '}';
    }
    
}
