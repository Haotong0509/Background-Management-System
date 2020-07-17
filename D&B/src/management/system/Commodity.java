package management.system;

import java.sql.*;
import java.util.Scanner;
import connection.JDBConnection;

public class Commodity {

    Connection con = null;

    public void AddCommodity() {
        System.out.println("======ADD COMMODITY======");
        Scanner s = new Scanner(System.in);
        int commodityID, businessID;
        String name, coarseClass, fineClass, description;
        float price;

        System.out.println("Commodity ID: ");
        commodityID = s.nextInt();
        System.out.println("Name: ");
        name = s.next();
        System.out.println("Price: ");
        price = s.nextFloat();
        System.out.println("CoarseClass: ");
        coarseClass = s.next();
        System.out.println("FineClass: ");
        fineClass = s.next();
        System.out.println("Description: ");
        description = s.next();
        System.out.println("BusinessID: ");
        businessID = s.nextInt();

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

    public void DeleteCommodity() {
        System.out.println("======DELETE COMMODITY======");
        System.out.println("Please enter the commodityID you want to delete: ");
        Scanner s = new Scanner(System.in);
        int commodityID = s.nextInt();
        System.out.println("The information about the commodity is as follows");
        FindByID(commodityID);
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

    public void UpdateCommodity() {
        System.out.println("======UPDATE COMMODITY======");
        System.out.println("Please enter the commodityId you want to update: ");
        Scanner s = new Scanner(System.in);
        int commodityID = s.nextInt();
        System.out.println("The information about the commodity is as follows");
        FindByID(commodityID);
        System.out.println("Please enter the updated information about the commodity");

        String name, coarseClass, fineClass, description;
        int businessID;
        float price;

        System.out.println("Name: ");
        name = s.next();
        System.out.println("Price: ");
        price = s.nextFloat();
        System.out.println("CoarseClass: ");
        coarseClass = s.next();
        System.out.println("FineClass: ");
        fineClass = s.next();
        System.out.println("Description: ");
        description = s.next();
        System.out.println("BusinessID: ");
        businessID = s.nextInt();

        try {
            con = JDBConnection.getConnection();
            String sql = "update commodity set itemName = ?, price = ?, coarseClass = ?, " +
                    "fineClass = ?, description = ?, BUSINESS_idBUSINESS = ? where idCOMMODITY = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setFloat(2, price);
            preparedStatement.setString(3, coarseClass);
            preparedStatement.setString(4, fineClass);
            preparedStatement.setString(5, description);
            preparedStatement.setInt(6, businessID);
            preparedStatement.setInt(7, commodityID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
    }

    public void QueryCommodity() {
        System.out.println("======QUERY COMMODITY======");
        System.out.println("commodityID   name       price   coarseClass   fineClass   description   businessID");
        try {
            con = JDBConnection.getConnection();
            String sql = "select * from commodity";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
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
