package management.system;

import java.sql.*;
import java.util.Scanner;
import connection.JDBConnection;

public class Business {

    Connection con = null;

    public void AddBusiness() {
        System.out.println("======ADD BUSINESS======");
        Scanner s = new Scanner(System.in);
        int idBUSINESS;
        String businessPassword,businessName;

        System.out.println("Business ID:");
        idBUSINESS = s.nextInt();
        System.out.println("Business Password: ");
        businessPassword = s.next();
        System.out.println("Business Name: ");
        businessName = s.next();

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
        System.out.println("Successfully Added");
    }

    public void DeleteBusiness() {
        System.out.println("======DELETE BUSINESS======");
        System.out.println("Please enter the businessID you want to delete: ");
        Scanner s = new Scanner(System.in);
        int idBUSINESS = s.nextInt();
        System.out.println("The information about the business is as follows");
        FindByID(idBUSINESS);
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

    public void UpdateBusiness() {
        System.out.println("======UPDATE BUSINESS======");
        System.out.println("Please enter the businessId you want to update: ");
        Scanner s = new Scanner(System.in);
        int idBUSINESS = s.nextInt();
        System.out.println("The information about the BUSINESS is as follows");
        FindByID(idBUSINESS);
        System.out.println("Please enter the updated information about the BUSINESS");

        String businessPassword,businessName;

        System.out.println("Business Password: ");
        businessPassword = s.next();
        System.out.println("Business Name: ");
        businessName = s.next();

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

    public void QueryBusiness() {
        System.out.println("======QUERY BUSINESS======");
        System.out.println("businessID    businessPassword    businessName");
        try {
            con = JDBConnection.getConnection();
            String sql = "select * from business";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
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
