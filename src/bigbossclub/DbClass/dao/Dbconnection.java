/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigbossclub.DbClass.dao;
import java.sql.*;
import java.sql.DriverManager;


public class Dbconnection {
        
        String driverClassName = "com.mysql.jdbc.Driver";
        String conUrl = "jdbc:mysql://localhost/mydb";
        String dbUser = "root";
        String dbPwd = "root";
        private Connection con = null;

        public Dbconnection(){
        
        try{
            if(con == null){
             Class.forName(driverClassName);
             con = DriverManager.getConnection(conUrl, dbUser, dbUser);
            }
            else{
                System.out.println("Already connection is established");
            }
        }
        
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    public Connection getCon() {
        return con;
    }
}


