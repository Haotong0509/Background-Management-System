package gui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.JDBConnection;


public class LoginVerify {

    Connection con = null;

    public boolean businessVerify(int businessID, String businessPassword){

        con = JDBConnection.getConnection();

        String select="SELECT * FROM BUSINESS WHERE idBUSINESS='"+businessID+"' and businessPassword='"+businessPassword+"'";
        boolean isVerifyBusiness=false;
        try {
            ResultSet rs=JDBConnection.runQuery(select);
            if(rs!=null)
            {
                isVerifyBusiness=rs.next();
                JDBConnection.realeaseAll();
            }
        } catch (SQLException ex) {
//	            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isVerifyBusiness;
    }

    public boolean adminVerify(int adminID, String adminPassword){

        con = JDBConnection.getConnection();

        String select="SELECT * FROM ADMINISTRATOR WHERE idADMINISTRATOR='"+adminID+"' and administratorPassword='"+adminPassword+"'";
        boolean isVerifyUser=false;
        try {
            ResultSet rs=JDBConnection.runQuery(select);
            if(rs!=null)
            {
                isVerifyUser=rs.next();
                JDBConnection.realeaseAll();
            }
        } catch (SQLException ex) {
//	            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isVerifyUser;
    }
}
