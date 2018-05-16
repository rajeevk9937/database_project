/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigbossclub.DbClass.Student;

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


public class historyDaoImp implements historyDao {

    @Override
    public List<history> getAllHistory() {

        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;

        List<history> historyList;
        historyList = new ArrayList<>();

        try {
            String query = "SELECT * FROM FeePayment";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                history hist = new history();
                hist.setId(rs.getInt("id"));
                hist.setPaid(rs.getFloat("paid"));
                hist.setPaid_date(rs.getDate("paiddate"));
                hist.setReason(rs.getString("reason"));
                hist.setHisfk_sid(rs.getInt("s_id"));
                historyList.add(hist);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return historyList;
    }

    @Override
    public void addHistory(history his) {

        Connection con = null;
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO FeePayment(paid,paiddate,reason,s_id) VALUES(?,?,?,?)";

        try {
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setFloat(1, his.getPaid());
            pstmt.setDate(2, his.getPaid_date());
            pstmt.setString(3, his.getReason());
            pstmt.setInt(4, his.getHisfk_sid());
            pstmt.executeUpdate();

            System.out.println("Record is inserted");
        } catch (SQLException e) {

            System.out.println(e);
        } finally {

            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                System.out.print(e);
            }

            if (con != null) {

                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
    }

    @Override
    public List<history> getUserHistory(int s_id) {
        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;

        List<history> historyList;
        historyList = new ArrayList<>();

        try {

            String query = "SELECT * FROM FeePayment where s_id = " + s_id;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {

                history hist = new history();
                hist.setId(rs.getInt("id"));
                hist.setPaid(rs.getFloat("paid"));
                hist.setPaid_date(rs.getDate("paiddate"));
                hist.setReason(rs.getString("reason"));
                hist.setHisfk_sid(rs.getInt("s_id"));
                historyList.add(hist);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {

            try {
                if (conn != null) {
                    conn.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
        return historyList;
    }

    @Override
    public void updateHistory(history his) {

        Connection con = null;
        PreparedStatement pstmt = null;


        String sql = "UPDATE FeePayment "
                + "SET paid = ?,"
                + "paiddate = ?,"
                + "reason = ?,"
                + "s_id = ? "
                + "WHERE id = ?";

        try {
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setDouble(1, his.getPaid());
            pstmt.setDate(2, his.getPaid_date());
            pstmt.setString(3, his.getReason());
            pstmt.setInt(4, his.getHisfk_sid());
            pstmt.setInt(5, his.getId());
            pstmt.executeUpdate();

            System.out.println("\nRecord is updated\n");
        } catch (SQLException e) {

            System.out.println(e);
        } finally {

            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                System.out.print(e);
            }

            if (con != null) {

                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }

    }

    @Override
    public void deleteHistory(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;

        String sql = "DELETE FROM FeePayment WHERE id = ?";

        try {
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Record is Deleted");
        } catch (SQLException e) {

            System.out.println(e);
        } finally {

            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                System.out.print(e);
            }

            if (con != null) {

                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }

    }

    @Override
    public history getHistory(int id) {

        Dbconnection dbcon = new Dbconnection();
        Connection conn = dbcon.getCon();
        Statement stmt = null;
        ResultSet rs = null;

        try {

            String query = "SELECT * FROM FeePayment where id = " + id;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                history hist = new history();
                hist.setId(rs.getInt("id"));
                hist.setPaid(rs.getFloat("paid"));
                hist.setPaid_date(rs.getDate("paiddate"));
                hist.setReason(rs.getString("reason"));
                hist.setHisfk_sid(rs.getInt("s_id"));
                return hist;

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {

            try {
                if (conn != null) {
                    conn.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
        return null;
    }

    @Override
    public void updateUserHistory(history his) {
        Connection con = null;
        PreparedStatement pstmt = null;

        String sql = "UPDATE FeePayment "
                + "SET paid = ?,"
                + "paiddate = ?,"
                + "reason = ? "
                + "WHERE s_id = ?";

        try {
            Dbconnection dbcon = new Dbconnection();
            con = dbcon.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setFloat(1, his.getPaid());
            pstmt.setDate(2, his.getPaid_date());
            pstmt.setString(3, his.getReason());
            pstmt.setInt(4, his.getHisfk_sid());
            pstmt.executeUpdate();

            System.out.println("\nRecord is updated\n");
        } catch (SQLException e) {

            System.out.println(e);
        } finally {

            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                System.out.print(e);
            }

            if (con != null) {

                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
    }
}
