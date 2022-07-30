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
public class Detail {
    private int ProductId;
    private int CategorieId;
    private int FunctionId;
    private String Description;

    public Detail(int ProductId, int CategorieId, int FunctionId, String Description) {
        this.ProductId = ProductId;
        this.CategorieId = CategorieId;
        this.FunctionId = FunctionId;
        this.Description = Description;
    }

    public Detail() {
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public int getCategorieId() {
        return CategorieId;
    }

    public void setCategorieId(int CategorieId) {
        this.CategorieId = CategorieId;
    }

    public int getFunctionId() {
        return FunctionId;
    }

    public void setFunctionId(int FunctionId) {
        this.FunctionId = FunctionId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "Detail{" + "ProductId=" + ProductId + ", CategorieId=" + CategorieId + ", FunctionId=" + FunctionId + ", Description=" + Description + '}';
    }
    
}
