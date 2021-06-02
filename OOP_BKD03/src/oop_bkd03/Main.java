/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_bkd03;
import java.sql.*;
/**
 *
 * @author T470S
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        System.out.print("hello");
        
        Connect dcm = new Connect("localhost:3306", "projectoop", "root", "");

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {

            connection = dcm.getConnection();

            statement = connection.createStatement();

            String sql = "SELECT * FROM employees";

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // close connections,...
            close(connection , statement, resultSet);
        }

    }

    private static void close(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
            
            if (statement != null) {
                statement.close();
            }
            
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
