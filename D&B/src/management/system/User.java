package management.system;

import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import connection.JDBConnection;

public class User {

    Connection con = null;

    public void AddTelNo() {
        try {
            con = JDBConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "insert into user(telNo) values(?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            for(int i = 0; i < 100; i++) {
                preparedStatement.setString(1, getTel());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            con.commit();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBConnection.closeConnection(con);
        }
    }

    public static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }
    private static String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");
    private static String getTel() {
        int index = getNum(0,telFirst.length-1);
        String first=telFirst[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String third=String.valueOf(getNum(1,9100)+10000).substring(1);
        return first+second+third;
    }

    public void AddUser() {
        System.out.println("======ADD USER======");
        Scanner s = new Scanner(System.in);
        int idUSER;
        String userPassword,userName;

        System.out.println("USER ID:");
        idUSER = s.nextInt();
        System.out.println("USER Name: ");
        userName = s.next();
        System.out.println("USER Password: ");
        userPassword = s.next();

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

    public void DeleteUser() {
        System.out.println("======DELETE USER======");
        System.out.println("Please enter the userID you want to delete: ");
        Scanner s = new Scanner(System.in);
        int idUSER = s.nextInt();
        System.out.println("The information about the user is as follows");
        FindByID(idUSER);
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

    public void UpdateUser() {
        System.out.println("======UPDATE USER======");
        System.out.println("Please enter the userId you want to update: ");
        Scanner s = new Scanner(System.in);
        int idUSER = s.nextInt();
        System.out.println("The information about the user is as follows");
        FindByID(idUSER);
        System.out.println("Please enter the updated information about the user");

        String userPassword, userName;

        System.out.println("Business Name: ");
        userName = s.next();
        System.out.println("Business Password: ");
        userPassword = s.next();

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

    public void QueryUser() {
        System.out.println("======QUERY USER======");
        System.out.println("userID    userName    userPassword");
        try {
            con = JDBConnection.getConnection();
            String sql = "select * from user";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
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

