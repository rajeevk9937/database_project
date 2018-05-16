/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigbossclub.DbClass.ClassAttendance;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bigbossclub.DbClass.dao.Dbconnection;

/**
 *
 * @author Mithi
 */
public class ClassesDaoImp implements classesDao {

    @Override
    public List<Classes> getAllClasses() {
        
        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;
        
        List<Classes> cList;
        cList = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM Class";
            stmt = conn.createStatement();
            rs =stmt.executeQuery(query);
            while(rs.next()){
                Classes eclass = new Classes();
                eclass.setC_id(rs.getInt("c_id"));
                eclass.setC_level(rs.getString("c_level"));
                eclass.setC_day(rs.getString("c_day"));
                eclass.setC_time(rs.getString("c_time"));
                cList.add(eclass);
            }
        }
        
        catch(SQLException e){
            System.out.println(e);
        }
        
        finally{
            try{
                if(conn != null){
                    conn.close();
                }
                if(stmt != null){
                    stmt.close();
                }
                if(rs != null){
                    rs.close();
                }
            }
            catch(SQLException e){
                System.out.println(e);
            }
        }
            
    return cList;
    
    }

    @Override
    public void addClass(Classes value) {
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "INSERT INTO class"
                + " VALUES(?,?,?,?)";
        
        try{
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            
            pstmt.setInt(1, value.getC_id() );
            pstmt.setString(2,value.getC_level() );
            pstmt.setString(3, value.getC_day());
            pstmt.setString(4,value.getC_time());
            pstmt.executeUpdate();
            
            System.out.println("Record is inserted");
        }
        
        catch(SQLException e){
            
            System.out.println(e);
        }
        
        finally{
            
            try{
                if(pstmt!=null) pstmt.close();
            }
            catch( SQLException e){
                System.out.print(e);
            }
            
            if(con != null){
                
                try{
                    con.close();
                }
                catch(SQLException e){
                    System.out.println(e);
                }
            }
        }
    }

    @Override
    public Classes getClass(int c_id) {
    
        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;
        try{
            
            String query = "SELECT * FROM class where c_id = "+c_id;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
             
                Classes eclass = new Classes();
                eclass.setC_id(rs.getInt("c_id"));
                eclass.setC_level(rs.getString("c_level"));
                eclass.setC_day(rs.getString("c_day"));
                eclass.setC_time(rs.getString("c_time"));
             
                return eclass;
            } 
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        finally{
         
            try{
                if(conn != null){
                    conn.close();
                }
                if(stmt != null){
                    stmt.close();
                }
                if(rs != null){
                    rs.close();
                }
            }
            
            catch(SQLException e){
                System.out.println(e);
            }
            
        }
         return null;
    }

    @Override
    public void updateClass(Classes value) {
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "UPDATE class "
                + "SET c_level = ?,"
                + "c_day = ?,"
                + "c_time = ? "
                + "WHERE c_id = ?";
        
        try{
            
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,value.getC_level());
            pstmt.setString(2, value.getC_day());
            pstmt.setString(3,value.getC_time());
            pstmt.setInt(4, value.getC_id());
            pstmt.executeUpdate();
            
            
            System.out.println("\nRecord is updated\n");
        }
        
        catch(SQLException e){
            
            System.out.println(e);
        }
        
        finally{
            
            try{
                if(pstmt != null) pstmt.close();
            }
            catch( SQLException e){
                System.out.print(e);
            }
            
            if(con != null){
                
                try{
                    con.close();
                }
                catch(SQLException e){
                    System.out.println(e);
                }
            }
        }
    }

    @Override
    public void deleteClass(int c_id) {
    
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "DELETE FROM class WHERE c_id = ?";
        
        try{
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,c_id);
            pstmt.executeUpdate();
            
            System.out.println("Record is Deleted \n");
        }
        
        catch(SQLException e){
            
            System.out.println(e);
        }
        
        finally{
            
            try{

                if(pstmt!=null)    pstmt.close();
            }
            catch( SQLException e){
                System.out.print(e);
            }
            
            if(con != null){
                
                try{
                    con.close();
                }
                catch(SQLException e){
                    System.out.println(e);
                }
            }
        }
    
    }
    
}