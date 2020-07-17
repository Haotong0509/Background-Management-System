package function;

import connection.JDBConnection;

import javax.swing.*;
import java.sql.*;
import java.util.Scanner;
import java.util.Vector;

public class User {

    Connection con = null;

    public void AddUser(JTextField tf1, JTextField tf2, JTextField tf3) {
        int idUSER;
        String userPassword,userName;

        idUSER = Integer.parseInt(tf1.getText());
        userName = tf2.getText();
        userPassword = tf3.getText();
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

    public void UpdateUser(JTextField tf1, JTextField tf2, JTextField tf3) {
        int idUSER = Integer.parseInt(tf1.getText());
        String userPassword, userName;

        userName = tf2.getText();
        userPassword = tf3.getText();

        try {
            con = JDBConnection.getConnection();
            String sql = "update user set userName = ?, userPassword = ? where idUSER = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPassword);
            preparedStatement.setInt(3, idUSER);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
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

