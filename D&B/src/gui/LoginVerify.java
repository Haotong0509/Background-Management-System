package gui;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
        businessPassword = toMd5(businessPassword);

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
        adminPassword = toMd5(adminPassword);

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
    
    public static String toMd5(String info) {

        byte[] secretByte;
        try {
            secretByte = MessageDigest.getInstance("md5")
                    .digest(info.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("找不到md5算法");
        }
        StringBuilder md5Code = new StringBuilder(new BigInteger(1, secretByte).toString(16));
        for (int i = 0; i < 32 - md5Code.length(); i++) {
            md5Code.insert(0, "0");
        }
        return md5Code.toString();
    }

}
