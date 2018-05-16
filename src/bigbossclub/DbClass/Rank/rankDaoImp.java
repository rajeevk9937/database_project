/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigbossclub.DbClass.Rank;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import bigbossclub.DbClass.dao.*;


 
public class rankDaoImp implements rankDao {

    @Override
    public List<rank> getAllRank() {
        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;
        
        List<rank> rankList;
        rankList = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM rank";
            stmt = conn.createStatement();
            rs =stmt.executeQuery(query);
            while(rs.next()){
                rank rankvalue = new rank();
                rankvalue.setR_id(rs.getInt("r_id"));
              //  rankvalue.setR_name(rs.getString("r_name"));
                rankvalue.setR_belt(rs.getString("r_belt"));
                rankList.add(rankvalue);
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
            
    return rankList;
    }

    @Override
    public void addRank(rank value) {
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "INSERT INTO rank VALUES(?,?)";
        
        try{
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,value.getR_id());
            //pstmt.setString(2, value.getR_name());
            pstmt.setString(2, value.getR_belt());
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
    public rank getRank(int r_id) {
    
        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;
        try{
            
            String query = "SELECT * FROM rank where r_id = "+r_id;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                rank rankvalue = new rank();
                rankvalue.setR_id(rs.getInt("r_id"));
               // rankvalue.setR_name(rs.getString("r_name"));
                rankvalue.setR_belt(rs.getString("r_belt"));
                return rankvalue;
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
    public void updateRank(rank value) {
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "UPDATE rank "
               // + "SET r_name = ?,"
                + " SET r_belt = ? "
                + "WHERE r_id = ?";
        
        try{
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
         //   pstmt.setString(1, value.getR_name());
            pstmt.setString(1, value.getR_belt());
            pstmt.setInt(2,value.getR_id());
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
    public void deleteRank(int r_id) {
    
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "DELETE FROM rank WHERE r_id = ?";
        
        try{
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,r_id);
            pstmt.executeUpdate();
            
            System.out.println("Record is Deleted");
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
    
}
