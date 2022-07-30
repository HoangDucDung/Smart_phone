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
public class Categorie {
    private int CategorieId;
    private Function funtionId;
    private String CategorieName;

    public Categorie() {
    }

    public Categorie(int CategorieId, Function funtionId, String CategorieName) {
        this.CategorieId = CategorieId;
        this.funtionId = funtionId;
        this.CategorieName = CategorieName;
    }

    public int getCategorieId() {
        return CategorieId;
    }

    public void setCategorieId(int CategorieId) {
        this.CategorieId = CategorieId;
    }

    public Function getFuntionId() {
        return funtionId;
    }

    public void setFuntionId(Function funtionId) {
        this.funtionId = funtionId;
    }

    public String getCategorieName() {
        return CategorieName;
    }

    public void setCategorieName(String CategorieName) {
        this.CategorieName = CategorieName;
    }

    @Override
    public String toString() {
        return "Categorie{" + "CategorieId=" + CategorieId + ", funtionId=" + funtionId + ", CategorieName=" + CategorieName + '}';
    }
    
}
