/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigbossclub.DbClass.Rank;

/**
 *
 * @author viswa
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import bigbossclub.DbClass.dao.Dbconnection;


public class ProgressDaoImp implements ProgressDao {

    @Override
    public List<Progress> getAllProgress() {
        
        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;
        
        List<Progress> pList;
        pList = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM progress";
            stmt = conn.createStatement();
            rs =stmt.executeQuery(query);
            while(rs.next()){
                Progress progvalue = new Progress();
                progvalue.setId(rs.getInt("id"));
                progvalue.setPr_date(rs.getDate("pr_date"));
                progvalue.setProgfk_sid(rs.getInt("Student_info_s_id"));
                progvalue.setProgfk_rid(rs.getInt("Rank_r_id"));
                pList.add(progvalue);
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
            
    return pList;
    }

    @Override
    public void addProgress(Progress value) {
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "INSERT INTO progress(pr_date,Student_info_s_id,Rank_r_id) VALUES(?,?,?)";
        
        try{
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setDate(1,value.getPr_date());
            pstmt.setInt(2, value.getProgfk_sid());
            pstmt.setInt(3, value.getProgfk_rid());
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
    public List<Progress> getrankProgress(int Rank_r_id) {
        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;
        
        List<Progress> pList;
        pList = new ArrayList<>();
        
        try{
            
            String query = "SELECT * FROM progress where Rank_r_id = "+Rank_r_id;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
           while(rs.next()){
                Progress progvalue = new Progress();
                progvalue.setId(rs.getInt("id"));
                progvalue.setPr_date(rs.getDate("pr_date"));
                progvalue.setProgfk_sid(rs.getInt("Student_info_s_id"));
                progvalue.setProgfk_rid(rs.getInt("Rank_r_id"));
                pList.add(progvalue);
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
         return pList;
    }

    @Override
    public List<Progress> getstudentProgress(int s_id) {
    
        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;
        
        List<Progress> pList;
        pList = new ArrayList<>();
        
        try{
            
            String query = "SELECT * FROM progress where Student_info_s_id = "+s_id;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
           while(rs.next()){
                Progress progvalue = new Progress();
                progvalue.setId(rs.getInt("id"));
                progvalue.setPr_date(rs.getDate("pr_date"));
                progvalue.setProgfk_sid(rs.getInt("Student_info_s_id"));
                progvalue.setProgfk_rid(rs.getInt("Rank_r_id"));
                pList.add(progvalue);
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
         return pList;
    }
    
    @Override
    public void updateProgress(Progress prog) {
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "UPDATE progress "
                + "SET pr_date = ?,"
                + "Student_info_s_id = ?,"
                + "Rank_r_id = ? "
                + "WHERE id = ?";
        
        try{
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setDate(1, prog.getPr_date());
            pstmt.setInt(2,prog.getProgfk_sid());
            pstmt.setInt(3, prog.getProgfk_rid());
            pstmt.setInt(4,prog.getId());
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
    public void deleteProg(int id) {
       Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "DELETE FROM progress WHERE id = ?";
        
        try{
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,id);
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

    @Override
    public Progress getProgress(int id) {
        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;
       
        try{
            
            String query = "SELECT * FROM progress where id = "+id;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
           while(rs.next()){
                Progress progvalue = new Progress();
                progvalue.setId(rs.getInt("id"));
                progvalue.setPr_date(rs.getDate("pr_date"));
                progvalue.setProgfk_sid(rs.getInt("Student_info_s_id"));
                progvalue.setProgfk_rid(rs.getInt("Rank_r_id"));
                return progvalue;
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
    
}
