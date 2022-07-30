package Models;


import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FPTSHOP
 */
public class Login {
    private int LoginID;
    private String User;
    private String Pass;
    private String Gender;
    private LocalDate birth;
    private String Phone;
    private String Email;
    private int Admin;

    public Login() {
    }

    public Login(int LoginID, String User, String Pass, String Gender, LocalDate birth, String Phone, String Email, int Admin) {
        this.LoginID = LoginID;
        this.User = User;
        this.Pass = Pass;
        this.Gender = Gender;
        this.birth = birth;
        this.Phone = Phone;
        this.Email = Email;
        this.Admin = Admin;
    }

    public Login(String User, String Pass, String Gender, LocalDate birth, String Phone, String Email) {
        this.User = User;
        this.Pass = Pass;
        this.Gender = Gender;
        this.birth = birth;
        this.Phone = Phone;
        this.Email = Email;
    }
    
    public int getLoginID() {
        return LoginID;
    }

    public void setLoginID(int LoginID) {
        this.LoginID = LoginID;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getAdmin() {
        return Admin;
    }

    public void setAdmin(int Admin) {
        this.Admin = Admin;
    }

    @Override
    public String toString() {
        return "Login{" + "LoginID=" + LoginID + ", User=" + User + ", Pass=" + Pass + ", Gender=" + Gender + ", birth=" + birth + ", Phone=" + Phone + ", Email=" + Email + ", Admin=" + Admin + '}';
    }
    
    
}
