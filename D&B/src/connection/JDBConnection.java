package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class JDBConnection {

    final static String driver = "com.mysql.cj.jdbc.Driver";
    final static String url = "jdbc:mysql://localhost:3306/design&build?&useSSL=false&serverTimezone=UTC";
    final static String user = "root";
    final static String password = "XHTXHTXHT";
    private static Connection con = null;
    private static Statement smt = null;
    private static ResultSet rs = null;

    public static Connection getConnection() {
        try {
//            Connection con = null;
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                return con;
            }
        } catch (ClassNotFoundException e) {
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    
    public static int runUpdate(String sql) throws SQLException {
        int count = 0;
        if (con == null) {
            con = getConnection();
        }
        if (smt == null) {
            smt = con.createStatement();
        }

        count = smt.executeUpdate(sql);

        if (smt != null) {
            smt.close();
            smt = null;
        }
        if (con != null) {
            con.close();
            con = null;
        }
        return count;
    }

    
    public static ResultSet runQuery(String sql) throws SQLException {
        if (con == null) {
            con = getConnection();
        }
        if (smt == null) {
            smt = con.createStatement();
        }
        return smt.executeQuery(sql);
    }

    public static void realeaseAll() {
        if (rs != null) {
            try {
                rs.close();
                rs = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (smt != null) {
            try {
                smt.close();
                smt = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
                con = null;
            } catch (SQLException ex) {
//                Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    public static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
