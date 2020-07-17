package function;

import connection.JDBConnection;

import javax.swing.*;

import java.awt.Color;
import java.sql.*;
import java.util.Scanner;
import java.util.Vector;

public class Order {

    Connection con = null;

    public void BusinessOrderManagement(JTextField tf1) {
        int idORDER_ALL = Integer.parseInt(tf1.getText());
        String status;
        status = "已发货";

        try {
            con = JDBConnection.getConnection();
            String sql = "update order_all set status = ? where idORDER_ALL = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, idORDER_ALL);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
    }

    public void FindByID(int ID) {
        try {
            con = JDBConnection.getConnection();
            String sql = "select * from order_all where idORDER_ALL = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int idORDER_ALL = resultSet.getInt("idORDER_ALL");
                String totalPrice = resultSet.getString("totalPrice");
                String orderTime = resultSet.getString("orderTime");
                String status = resultSet.getString("status");

                System.out.println("orderID    totalPrice    orderTime            status");
                System.out.printf("%-11s%-14s%-21s%-10s\n", idORDER_ALL, totalPrice, orderTime, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
    }

    public void QueryOrder(JPanel newJPanel) {
        Vector columnNames=new Vector();
        columnNames.add("order_record ID");
    	columnNames.add("order_all ID");
		columnNames.add("total price");
		columnNames.add("order time");
		columnNames.add("order status");
		columnNames.add("userID");
		Vector rowData = new Vector();
        try {
            con = JDBConnection.getConnection();
            String sql = "SELECT r.idORDER_RECORD, a.idORDER_ALL, a.totalPrice, a.orderTime, a.status, cart.USER_idUSER from commodity c, " +
        			"order_all a, order_record r, cart  where  c.idCOMMODITY = " +
        			"r.COMMODITY_idCOMMODITY AND r.ORDER_ALL_idORDER_ALL = a.idORDER_ALL AND cart.idCART = a.CART_idCART";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
            	Vector row=new Vector();
            	row.add(rs.getInt(1));
				row.add(rs.getInt(2));
				row.add(rs.getFloat(3));
				row.add(rs.getString(4));
				row.add(rs.getString(5));
				row.add(rs.getInt(6));

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

    public void BusinessQueryOrder(int idBUSINESS, JPanel newJPanel) {
    	Vector columnNames=new Vector();
    	columnNames.add("order_record ID");
    	columnNames.add("order_all ID");
		columnNames.add("total price");
		columnNames.add("order time");
		columnNames.add("order status");
		columnNames.add("userID");
		Vector rowData = new Vector();
		try {
            con = JDBConnection.getConnection();
            String sql = "SELECT r.idORDER_RECORD, a.idORDER_ALL, a.totalPrice, a.orderTime, a.status, cart.USER_idUSER from commodity c, " +
            			"order_all a, order_record r, cart  where c.BUSINESS_idBUSINESS = " + idBUSINESS + " AND c.idCOMMODITY = " +
            			"r.COMMODITY_idCOMMODITY AND r.ORDER_ALL_idORDER_ALL = a.idORDER_ALL AND cart.idCART = a.CART_idCART";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
            	Vector row=new Vector();
				row.add(rs.getInt(1));
				row.add(rs.getInt(2));
				row.add(rs.getFloat(3));
				row.add(rs.getString(4));
				row.add(rs.getString(5));
				row.add(rs.getInt(6));

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

    public void BusinessQueryOrder1(int idBUSINESS, String beginTime, String endTime, JPanel newJPanel) {
    	newJPanel.removeAll();
    	try {
            con = JDBConnection.getConnection();
            String sql = "SELECT count(a.idORDER_ALL), sum(a.totalPrice) \n" +
                    "from commodity c, order_all a, order_record r \n" +
                    "where c.BUSINESS_idBUSINESS = ? \n" +
                    "AND c.idCOMMODITY = r.COMMODITY_idCOMMODITY \n" +
                    "AND r.ORDER_ALL_idORDER_ALL = a.idORDER_ALL \n" +
                    "AND unix_timestamp(?) < unix_timestamp(a.orderTime)\n" +
                    "AND unix_timestamp(?) > unix_timestamp(a.orderTime);";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, idBUSINESS);
            preparedStatement.setString(2, beginTime);
            preparedStatement.setString(3, endTime);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int totalOrderNum = resultSet.getInt("count(a.idORDER_ALL)");
                float totalPriceSum = resultSet.getFloat("sum(a.totalPrice)");
                newJPanel.add(new JLabel("<html>订单单数：" + totalOrderNum + "<br>订单总金额（元）: " + totalPriceSum + "</html>"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
    }

    public void BusinessQueryOrder2(int idBUSINESS, String commodityClass, JPanel newJPanel) {
    	newJPanel.removeAll();
        try {
            con = JDBConnection.getConnection();
            String sql = "SELECT count(a.idORDER_ALL), sum(a.totalPrice) \n" +
                    "from commodity c, order_all a, order_record r \n" +
                    "where c.BUSINESS_idBUSINESS = ? \n" +
                    "AND c.idCOMMODITY = r.COMMODITY_idCOMMODITY \n" +
                    "AND r.ORDER_ALL_idORDER_ALL = a.idORDER_ALL \n" +
                    "AND (c.coarseClass = ? OR c.fineClass = ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, idBUSINESS);
            preparedStatement.setString(2, commodityClass);
            preparedStatement.setString(3, commodityClass);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int totalOrderNum = resultSet.getInt("count(a.idORDER_ALL)");
                float totalPriceSum = resultSet.getFloat("sum(a.totalPrice)");
                newJPanel.add(new JLabel("<html>订单单数：" + totalOrderNum + "<br>订单总金额（元）: " + totalPriceSum + "</html>"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
    }

    public void BusinessQueryOrder3(int idBUSINESS, String beginTime, String endTime, JPanel newJPanel) {
        newJPanel.removeAll();
    	Vector columnNames=new Vector();
        columnNames.add("商品ID");
    	columnNames.add("商品名");
    	columnNames.add("商品销量");
    	Vector rowData = new Vector();
        try {
            con = JDBConnection.getConnection();
            String sql = "SELECT * FROM (SELECT c. idCOMMODITY, c.itemName, count(c.itemName) COUNT FROM commodity c, order_all a, order_record r \n" +
                    "         WHERE c.BUSINESS_idBUSINESS = ? \n" +
                    "         AND c.idCOMMODITY = r.COMMODITY_idCOMMODITY \n" +
                    "         AND r.ORDER_ALL_idORDER_ALL = a.idORDER_ALL \n" +
                    "         AND unix_timestamp(?) < unix_timestamp(a.orderTime)\n" +
                    "         AND unix_timestamp(?) > unix_timestamp(a.orderTime)" +
                    "         GROUP BY idCOMMODITY\n" +
                    "         ORDER BY COUNT desc)" +
                    "         as total limit 0, 10;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, idBUSINESS);
            preparedStatement.setString(2, beginTime);
            preparedStatement.setString(3, endTime);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                Vector row=new Vector();
                row.add(rs.getInt(1));
				row.add(rs.getString(2));
				row.add(rs.getInt(3));
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

    public void AdminQueryOrder1(String beginTime, String endTime, JPanel newJPanel) {
    	newJPanel.removeAll();
        try {
            con = JDBConnection.getConnection();
            String sql = "SELECT count(a.idORDER_ALL), sum(a.totalPrice) \n" +
                    "from order_all a\n" +
                    "WHERE unix_timestamp(?) < unix_timestamp(a.orderTime)\n" +
                    "AND unix_timestamp(?) > unix_timestamp(a.orderTime);";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, beginTime);
            preparedStatement.setString(2, endTime);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int totalOrderNum = resultSet.getInt("count(a.idORDER_ALL)");
                float totalPriceSum = resultSet.getFloat("sum(a.totalPrice)");
                newJPanel.add(new JLabel("<html>订单单数：" + totalOrderNum + "<br>订单总金额（元）: " + totalPriceSum + "</html>"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
    }

    public void AdminQueryOrder2(String commodityClass, JPanel newJPanel) {
    	newJPanel.removeAll();
        try {
            con = JDBConnection.getConnection();
            String sql = "SELECT count(a.idORDER_ALL), sum(a.totalPrice) \n" +
                    "from commodity c, order_all a, order_record r\n" +
                    "WHERE (c.coarseClass = ? OR c.fineClass = ?)" +
                    "AND c.idCOMMODITY = r.COMMODITY_idCOMMODITY \n" +
                    "AND r.ORDER_ALL_idORDER_ALL = a.idORDER_ALL \n";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, commodityClass);
            preparedStatement.setString(2, commodityClass);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int totalOrderNum = resultSet.getInt("count(a.idORDER_ALL)");
                float totalPriceSum = resultSet.getFloat("sum(a.totalPrice)");
                newJPanel.add(new JLabel("<html>订单单数：" + totalOrderNum + "<br>订单总金额（元）: " + totalPriceSum + "</html>"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
    }

    public void AdminQueryOrder3(String beginTime, String endTime, JPanel newJPanel) {
    	newJPanel.removeAll();
    	Vector columnNames=new Vector();
        columnNames.add("商品ID");
    	columnNames.add("商品名");
    	columnNames.add("商品销量");
    	Vector rowData = new Vector();
        try {
            con = JDBConnection.getConnection();
            String sql = "SELECT * FROM (SELECT c.idCOMMODITY, c.itemName, count(c.itemName) COUNT FROM commodity c, order_all a, order_record r \n" +
                    "         WHERE c.idCOMMODITY = r.COMMODITY_idCOMMODITY \n" +
                    "         AND r.ORDER_ALL_idORDER_ALL = a.idORDER_ALL \n" +
                    "         AND unix_timestamp(?) < unix_timestamp(a.orderTime)\n" +
                    "         AND unix_timestamp(?) > unix_timestamp(a.orderTime)" +
                    "         GROUP BY idCOMMODITY\n" +
                    "         ORDER BY COUNT desc)" +
                    "         as total limit 0, 10;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, beginTime);
            preparedStatement.setString(2, endTime);
            ResultSet rs = preparedStatement.executeQuery();
           
            while(rs.next()) {
                Vector row=new Vector();
                row.add(rs.getInt(1));
				row.add(rs.getString(2));
				row.add(rs.getInt(3));
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

    public void AdminQueryOrder4(String beginTime, String endTime, JPanel newJPanel) {
    	newJPanel.removeAll();
    	Vector columnNames=new Vector();
        columnNames.add("商家ID");
    	columnNames.add("订单单数");
    	columnNames.add("订单总金额（元）");
    	Vector rowData = new Vector();
        try {
            con = JDBConnection.getConnection();
            String sql = "SELECT c.BUSINESS_idBUSINESS, count(a.idORDER_ALL), sum(a.totalPrice) \n" +
                    "    from commodity c, order_all a, order_record r \n" +
                    "    where c.idCOMMODITY = r.COMMODITY_idCOMMODITY \n" +
                    "    AND r.ORDER_ALL_idORDER_ALL = a.idORDER_ALL \n" +
                    "    AND unix_timestamp(?) < unix_timestamp(a.orderTime)\n" +
                    "    AND unix_timestamp(?) > unix_timestamp(a.orderTime)\n" +
                    "    GROUP BY c.BUSINESS_idBUSINESS\n" +
                    "    ORDER BY c.BUSINESS_idBUSINESS";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, beginTime);
            preparedStatement.setString(2, endTime);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                Vector row=new Vector();
                row.add(rs.getInt(1));
				row.add(rs.getInt(2));
				row.add(rs.getFloat(3));
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

    public void AdminQueryOrder5(String beginTime, String endTime, JPanel newJPanel) {
    	newJPanel.removeAll();
    	Vector columnNames=new Vector();
        columnNames.add("商家ID");
    	columnNames.add("商家销售额（元）");
    	Vector rowData = new Vector();
        try {
            con = JDBConnection.getConnection();
            String sql = "SELECT BUSINESS_idBUSINESS, SUM FROM \n" +
                    "(SELECT c.BUSINESS_idBUSINESS, count(a.idORDER_ALL), sum(a.totalPrice) SUM\n" +
                    "    from commodity c, order_all a, order_record r \n" +
                    "    where c.idCOMMODITY = r.COMMODITY_idCOMMODITY \n" +
                    "    AND r.ORDER_ALL_idORDER_ALL = a.idORDER_ALL \n" +
                    "    AND unix_timestamp(?) < unix_timestamp(a.orderTime)\n" +
                    "    AND unix_timestamp(?) > unix_timestamp(a.orderTime)\n" +
                    "    GROUP BY c.BUSINESS_idBUSINESS\n" +
                    "    ORDER BY SUM desc)\n" +
                    "    as total limit 0, 10;\n";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, beginTime);
            preparedStatement.setString(2, endTime);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Vector row=new Vector();
                row.add(rs.getInt(1));
				row.add(rs.getFloat(2));
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

    public void AdminQueryOrder6(String beginTime, String endTime, JPanel newJPanel) {
    	newJPanel.removeAll();
    	Vector columnNames=new Vector();
        columnNames.add("用户ID");
    	columnNames.add("用户下单总额");
    	Vector rowData = new Vector();
        try {
            con = JDBConnection.getConnection();
            String sql = "SELECT * FROM (SELECT c.USER_idUSER, sum(a.totalPrice) SUM\n" +
                    "from cart c, order_all a\n" +
                    "where c.idCART = a.CART_idCART\n" +
                    "AND unix_timestamp(?) < unix_timestamp(a.orderTime)\n" +
                    "AND unix_timestamp(?) > unix_timestamp(a.orderTime)\n" +
                    "GROUP BY c.USER_idUSER\n" +
                    "ORDER BY SUM desc)\n" +
                    "as total limit 0, 10;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, beginTime);
            preparedStatement.setString(2, endTime);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                Vector row=new Vector();
                row.add(rs.getInt(1));
				row.add(rs.getFloat(2));
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

    public void AdminQueryOrder7(JPanel newJPanel) {
    	Vector columnNames=new Vector();
    	columnNames.add("年份");
    	columnNames.add("月份");
		columnNames.add("订单数量");
		columnNames.add("订单总金额");
		Vector rowData = new Vector();
    	
        try {
            con = JDBConnection.getConnection();
            String sql = "SELECT year(a.orderTime) as year, month(a.orderTime) as month, " +
                    "count(a.idORDER_ALL) as COUNT, sum(a.totalPrice) as SUM\n" +
                    "FROM order_all a\n" +
                    "GROUP BY year, month\n" +
                    "ORDER BY year, month asc;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Vector row=new Vector();
                row.add(rs.getInt(1));
				row.add(rs.getInt(2));
				row.add(rs.getInt(3));
				row.add(rs.getFloat(4));
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



}
