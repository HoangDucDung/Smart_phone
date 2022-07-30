/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FPTSHOP
 */
public class DBcontext {
    protected Connection connection;
    public DBcontext()
    {
        try{
            String user="sa";
            String pass="hoangdung1110";
            String url="jdbc:sqlserver://HoangDung:1433;databaseName=SmartPhone";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        }
        catch(Exception ex)
        {
            Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static void main(String[] args) {
        DBcontext d = new DBcontext();
        System.out.println(d.connection);
    }
}
