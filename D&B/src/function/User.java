package function;

import connection.JDBConnection;

import javax.swing.*;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.util.Random;

public class User {

    Connection con = null;

    public void AddUser(JTextField tf1, JTextField tf2, JTextField tf3) {
        int idUSER;
        String userPassword,userName;

        idUSER = Integer.parseInt(tf1.getText());
        userName = tf2.getText();
        userPassword = toMd5(tf3.getText());
        String sql = "insert into user(idUSER, userName, userPassword) values(?, ?, ?)";
        try {
            con = JDBConnection.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, idUSER);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, userPassword);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
        System.out.println("Successfully Added");
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

    public void DeleteUser(JTextField tf1) {
        int idUSER = Integer.parseInt(tf1.getText());
        try {
            con = JDBConnection.getConnection();
            String sql = "delete from user where idUSER = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, idUSER);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
    }

//    public void UpdateUser(JTextField tf1, JTextField tf2, JTextField tf3) {
//        int idUSER = Integer.parseInt(tf1.getText());
//        String userPassword, userName;
//
//        userName = tf2.getText();
//        userPassword = tf3.getText();
//
//        try {
//            con = JDBConnection.getConnection();
//            String sql = "update user set userName = ?, userPassword = ? where idUSER = ?";
//            PreparedStatement preparedStatement = con.prepareStatement(sql);
//            preparedStatement.setString(1, userName);
//            preparedStatement.setString(2, userPassword);
//            preparedStatement.setInt(3, idUSER);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            JDBConnection.closeConnection(con);
//        }
//    }
    public void UpdateUser(JTextField tf1, JLabel resultJLabel) {
        int idUSER = Integer.parseInt(tf1.getText());
        String userPassword = RandomString(6);        //随机生成6位密码
        resultJLabel.setText("密码重置为：" + userPassword);
        userPassword = toMd5(userPassword);		//进行md5加密
        try {
            con = JDBConnection.getConnection();
            String sql = "update user set userPassword = ? where idUSER = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, userPassword);
            preparedStatement.setInt(2, idUSER);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
    }
    
    public static String RandomString(int length) {
        String alphabetsInUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetsInLowerCase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        Random random = new Random();
        // create a super set of all characters
        String allCharacters = alphabetsInLowerCase + alphabetsInUpperCase + numbers;
        // initialize a string to hold result
        StringBuffer randomString = new StringBuffer();
        // loop for 10 times
        for (int i = 0; i < length; i++) {
            // generate a random number between 0 and length of all characters 
            int randomIndex = random.nextInt(allCharacters.length());
            // retrieve character at index and add it to result
            randomString.append(allCharacters.charAt(randomIndex));
        }
        return randomString.toString();
   }

    public void QueryUser(JPanel newJPanel) {
    	
    	Vector columnNames=new Vector();
    	columnNames.add("userID");
		columnNames.add("userName");
		columnNames.add("userPassword");
		Vector rowData = new Vector();
		try {
            con = JDBConnection.getConnection();
            String sql = "select idUSER, userName, userPassword FROM user";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
            	Vector row=new Vector();
				row.add(rs.getInt(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));

				rowData.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
		
		JTable jt = new JTable(rowData,columnNames);
		
		JScrollPane jsp = new JScrollPane(jt);
		
		newJPanel.add(jsp);
    }

    public void FindByID(int ID) {
        try {
            con = JDBConnection.getConnection();
            String sql = "select * from user where idUSER = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int idUSER = resultSet.getInt("idUSER");
                String userPassword = resultSet.getString("userPassword");
                String userName = resultSet.getString("userName");

                System.out.printf("%-10s%-12s%-16s\n", idUSER, userName, userPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
    }

}

