/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigbossclub.DbClass.Parents;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bigbossclub.DbClass.dao.*;

/**
 *
 * @author Mithi
 */
public class parent_infoDaoImp implements parent_infoDao {

    @Override
    public List<parent_info> getAllparents() {
        
        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;
        
        List<parent_info> parentList;
        parentList = new ArrayList<parent_info>();
        
        try{
            String query = "SELECT * FROM Parent_info";
            stmt = conn.createStatement();
            rs =stmt.executeQuery(query);
            while(rs.next()){
                parent_info parent = new parent_info();
                parent.setP_id(rs.getInt("p_id"));
                parent.setP_fname(rs.getString("p_fname"));
                parent.setP_lname(rs.getString("p_lname"));
                parent.setP_relation(rs.getString("p_relation"));
                parent.setP_mobile(rs.getLong("p_mob"));
                parent.setP_email(rs.getString("p_email"));
                parent.setParentfk_s_sid(rs.getInt("Student_info_s_id"));
                parentList.add(parent);
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
            
    return parentList;
        
    }

    @Override
    public void addParent(parent_info parent) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "INSERT INTO Parent_info(p_fname,p_lname,p_relation,p_mob,p_email,Student_info_s_id)"
                + " VALUES(?,?,?,?,?,?)";
        
        try{
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, parent.getP_fname());
            pstmt.setString(2, parent.getP_lname());
            pstmt.setString(3, parent.getP_relation());
            pstmt.setLong(4,parent.getP_mobile());
            pstmt.setString(5, parent.getP_email());
            pstmt.setInt(6, parent.getParentfk_s_sid());
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
    public parent_info getParent(int p_id) {
    
        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;
        try{
            
            String query = "SELECT * FROM Parent_info where Student_info_s_id = "+p_id;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                parent_info parent = new parent_info();
                parent.setP_id(rs.getInt("p_id"));
                parent.setP_fname(rs.getString("p_fname"));
                parent.setP_lname(rs.getString("p_lname"));
                parent.setP_relation(rs.getString("p_relation"));
                parent.setP_mobile(rs.getLong("p_mob"));
                parent.setP_email(rs.getString("p_email"));
                parent.setParentfk_s_sid(rs.getInt("Student_info_s_id"));
                return parent;
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
    public void updateParent(parent_info parent) {
    
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "UPDATE Parent_info "
                + "SET p_fname = ?,"
                + "p_lname = ?,"
                + "p_relation = ?,"
                + "p_mob = ?,"
                + "p_email = ?,"
                + "Student_info_s_id = ? "
                + "WHERE Student_info_s_id = ?";
        
        try{
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, parent.getP_fname());
            pstmt.setString(2, parent.getP_lname());
            pstmt.setString(3, parent.getP_relation());
            pstmt.setLong(4,parent.getP_mobile());
            pstmt.setString(5, parent.getP_email());
            pstmt.setInt(6, parent.getParentfk_s_sid());
            pstmt.setInt(7, parent.getParentfk_s_sid());
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
    public void deleteParent(int p_id) {
    
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "DELETE FROM parent_info WHERE p_id = ?";
        
        try{
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,p_id);
            pstmt.executeUpdate();
            
            System.out.println("Record is Deleted using parentid");
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

    @Override
    public List<parent_info> getUserparents(int s_id) {
        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;
        List<parent_info> parentList;
        parentList = new ArrayList<>();
        
        try{
            
            String query = "SELECT * FROM Parent_info where Student_info_s_id = "+s_id;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                parent_info parent = new parent_info();
                parent.setP_id(rs.getInt("p_id"));
                parent.setP_fname(rs.getString("p_fname"));
                parent.setP_lname(rs.getString("p_lname"));
                parent.setP_relation(rs.getString("p_relation"));
                parent.setP_mobile(rs.getLong("p_mob"));
                parent.setP_email(rs.getString("p_email"));
                parent.setParentfk_s_sid(rs.getInt("Student_info_s_id"));
                parentList.add(parent);
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
         return parentList;
    }
}
    
