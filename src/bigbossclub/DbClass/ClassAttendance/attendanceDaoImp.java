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


public class attendanceDaoImp implements attendanceDao {

    @Override
    public List<attendance> getAllattendance() {
                
        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;
        
        List<attendance> aList;
        aList = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM attendance";
            stmt = conn.createStatement();
            rs =stmt.executeQuery(query);
            while(rs.next()){
                attendance attend = new attendance();
                attend.setId(rs.getInt("id"));
                attend.setFk_c_id(rs.getInt("Class_c_id"));
                attend.setAttfk_s_id(rs.getInt("Student_info_s_id"));
                aList.add(attend);
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
            
    return aList;
    
    }

    @Override
    public void addAttendance(attendance value) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "INSERT INTO attendance(Class_c_id,Student_info_s_id)"
                + " VALUES(?,?)";
        
        try{
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            
            pstmt.setInt(1, value.getFk_c_id() );
            pstmt.setInt(2,value.getAttfk_s_id());
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
    public attendance getAttendance(int id) {
     
        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;
        
    
        try{
            String query = "SELECT * FROM attendance WHERE id = "+id;
            stmt = conn.createStatement();
            rs =stmt.executeQuery(query);
            while(rs.next()){
                attendance attend = new attendance();
                attend.setId(rs.getInt("id"));
                attend.setFk_c_id(rs.getInt("Class_c_id"));
                attend.setAttfk_s_id(rs.getInt("Student_info_s_id"));
                return attend;
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
    public List<attendance> getAttendanceClass(int c_id) {
        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;
        
        List<attendance> aList;
        aList = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM attendance WHERE Class_c_id = "+c_id;
            stmt = conn.createStatement();
            rs =stmt.executeQuery(query);
            while(rs.next()){
                attendance attend = new attendance();
                attend.setId(rs.getInt("id"));
                attend.setFk_c_id(rs.getInt("Class_c_id"));
                attend.setAttfk_s_id(rs.getInt("Student_info_s_id"));
                aList.add(attend);
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
            
    return aList;
    }

    @Override
    public List<attendance> getAttendanceStudent(int s_id) {
        
         Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;
        
        List<attendance> aList;
        aList = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM attendance WHERE Student_info_s_id = "+s_id;
            stmt = conn.createStatement();
            rs =stmt.executeQuery(query);
            while(rs.next()){
                attendance attend = new attendance();
                attend.setId(rs.getInt("id"));
                attend.setFk_c_id(rs.getInt("Class_c_id"));
                attend.setAttfk_s_id(rs.getInt("Student_info_s_id"));
                aList.add(attend);
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
            
    return aList;
    }

    @Override
    public void updateAttendance(attendance value) {
    
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "UPDATE attendance "
                + "SET Class_c_id = ?,"
                + "Student_info_s_id = ? "
                + "WHERE id = ?";
        
        try{
            
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, value.getFk_c_id() );
            pstmt.setInt(2,value.getAttfk_s_id());
            pstmt.setInt(3, value.getId());
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
    public void deleteAttendance(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "DELETE FROM attendance WHERE id = ?";
        
        try{
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,id);
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
