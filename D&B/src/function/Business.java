package function;

import connection.JDBConnection;

import javax.swing.*;
import java.sql.*;
import java.util.Scanner;
import java.util.Vector;

public class Business {

    Connection con = null;

    public void AddBusiness(JTextField tf1, JTextField tf2, JTextField tf3) {
        int idBUSINESS;
        String businessPassword,businessName;

        idBUSINESS = Integer.parseInt(tf1.getText());
        businessName = tf2.getText();
        businessPassword = tf3.getText();

        String sql = "insert into business(idBUSINESS, businessPassword, businessName) values(?, ?, ?)";
        try {
            con = JDBConnection.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, idBUSINESS);
            preparedStatement.setString(2, businessPassword);
            preparedStatement.setString(3, businessName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
    }

    public void DeleteBusiness(JTextField tf1) {
        int idBUSINESS = Integer.parseInt(tf1.getText());
        try {
            con = JDBConnection.getConnection();
            String sql = "delete from business where idBUSINESS = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, idBUSINESS);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
    }

    public void UpdateBusiness(JTextField tf1, JTextField tf2, JTextField tf3) {
        int idBUSINESS;
        String businessPassword,businessName;

        idBUSINESS = Integer.parseInt(tf1.getText());
        businessName = tf2.getText();
        businessPassword = tf3.getText();

        try {
            con = JDBConnection.getConnection();
            String sql = "update business set businessPassword = ?, businessName = ? where idBUSINESS = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, businessPassword);
            preparedStatement.setString(2, businessName);
            preparedStatement.setInt(3, idBUSINESS);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
    }

    public void QueryBusiness(JPanel newJPanel) {
    	Vector columnNames=new Vector();
    	columnNames.add("businessID");
		columnNames.add("businessName");
		columnNames.add("businessPassword");
		Vector rowData = new Vector();
        try {
            con = JDBConnection.getConnection();
            String sql = "select idBUSINESS, businessName, businessPassword from business";
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
            String sql = "select * from BUSINESS where idBUSINESS = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int idBUSINESS = resultSet.getInt("idBUSINESS");
                String businessPassword = resultSet.getString("businessPassword");
                String businessName = resultSet.getString("businessName");

                System.out.printf("%-14s%-20s%-16s\n", idBUSINESS, businessPassword, businessName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
    }

}
