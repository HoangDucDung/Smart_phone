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
public class Function {
    private int FuntionId;
    private String FuntionName;

    public Function() {
    }

    public Function(int FuntionId, String FuntionName) {
        this.FuntionId = FuntionId;
        this.FuntionName = FuntionName;
    }

    public Function(int FuntionId) {
        this.FuntionId = FuntionId;
    }
    
    public int getFuntionId() {
        return FuntionId;
    }

    public void setFuntionId(int FuntionId) {
        this.FuntionId = FuntionId;
    }

    public String getFuntionName() {
        return FuntionName;
    }

    public void setFuntionName(String FuntionName) {
        this.FuntionName = FuntionName;
    }

    @Override
    public String toString() {
        return "Function{" + "FuntionId=" + FuntionId + ", FuntionName=" + FuntionName + '}';
    }
    
    
}
