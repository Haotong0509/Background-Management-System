package function;

import connection.JDBConnection;
import javax.swing.*;
import java.sql.*;
import java.util.Scanner;
import java.util.*;

public class Commodity {

    Connection con = null;

    public void BusinessAddCommodity(JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4, JTextField tf5, int businessID) {
        int commodityID;
        String name, coarseClass, fineClass, description;
        float price;

        commodityID = Integer.parseInt(tf1.getText());
        name = tf2.getText();
        price = Float.parseFloat(tf3.getText());
        coarseClass = tf4.getText();
        fineClass = tf5.getText();
        description = "null";

        String sql = "insert into commodity(idCOMMODITY, itemName, price, coarseClass, fineClass, " +
                "description, BUSINESS_idBUSINESS) values(?, ?, ?, ?, ?, ?, ?)";

        try {
            con = JDBConnection.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, commodityID);
            preparedStatement.setString(2, name);
            preparedStatement.setFloat(3, price);
            preparedStatement.setString(4, coarseClass);
            preparedStatement.setString(5, fineClass);
            preparedStatement.setString(6, description);
            preparedStatement.setInt(7, businessID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
        System.out.println("Successfully Added");
    }

    public void DeleteCommodity(JTextField tf1) {
        int commodityID = Integer.parseInt(tf1.getText());
        try {
            con = JDBConnection.getConnection();
            String sql = "delete from commodity where idCOMMODITY = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, commodityID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
    }

    public void UpdateCommodity(JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4, JTextField tf5) {
        int commodityID;
        String name, coarseClass, fineClass, description;
        int businessID;
        float price;

        commodityID = Integer.parseInt(tf1.getText());
        name = tf2.getText();
        price = Float.parseFloat(tf3.getText());
        coarseClass = tf4.getText();
        fineClass = tf5.getText();
        description = "null";
//        businessID = Integer.parseInt(tf6.getText());

        try {
            con = JDBConnection.getConnection();
            String sql = "update commodity set itemName = ?, price = ?, coarseClass = ?, " +
                    "fineClass = ?, description = ? where idCOMMODITY = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setFloat(2, price);
            preparedStatement.setString(3, coarseClass);
            preparedStatement.setString(4, fineClass);
            preparedStatement.setString(5, description);
//            preparedStatement.setInt(6, businessID);
            preparedStatement.setInt(6, commodityID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
    }


    public void QueryCommodity(JPanel newJPanel) {
    	Vector columnNames=new Vector();
    	columnNames.add("commodityID");
		columnNames.add("name");
		columnNames.add("price");
		columnNames.add("coarseClass");
		columnNames.add("fineClass");
		columnNames.add("businessID");
		Vector rowData = new Vector();
		try {
            con = JDBConnection.getConnection();
            String sql = "select * from commodity";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
            	Vector row=new Vector();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				row.add(rs.getFloat(7));
				row.add(rs.getString(11));
				row.add(rs.getString(12));
				row.add(rs.getInt(13));

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
    
    public void BusinessQueryCommodity(JPanel newJPanel, int businessID) {
    	Vector columnNames=new Vector();
    	columnNames.add("commodityID");
		columnNames.add("name");
		columnNames.add("price");
		columnNames.add("coarseClass");
		columnNames.add("fineClass");
		columnNames.add("businessID");
		Vector rowData = new Vector();
		try {
            con = JDBConnection.getConnection();
            String sql = "select * from commodity WHERE BUSINESS_idBUSINESS = " + businessID;
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
            	Vector row=new Vector();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				row.add(rs.getFloat(7));
				row.add(rs.getString(11));
				row.add(rs.getString(12));
				row.add(rs.getInt(13));

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
            String sql = "select * from commodity where idCOMMODITY = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int commodityID = resultSet.getInt("idCOMMODITY");
                String name = resultSet.getString("itemName");
                float price = resultSet.getFloat("price");
                String coarseClass = resultSet.getString("coarseClass");
                String fineClass = resultSet.getString("fineClass");
                String description = resultSet.getString("description");
                int businessID = resultSet.getInt("BUSINESS_idBUSINESS");

                System.out.printf("%-13s%-9s%-8s%-14s%-12s%-14s%-10s\n", commodityID, name, price,
                        coarseClass, fineClass, description, businessID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
    }
}
