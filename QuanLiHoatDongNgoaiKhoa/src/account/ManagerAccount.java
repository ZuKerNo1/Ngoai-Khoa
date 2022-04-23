/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author AD
 */
public class ManagerAccount {

    public Account getAccount(String userName, String passWord) throws SQLException {
        try {
            Connection connection = JDBCConnection.JDBCConnection();
            String sql = "select * from account where userName = ? and passWord = ?";
            Account account = new Account();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, passWord);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                account.setUserName(rs.getString("userName"));
                account.setPassWord(rs.getString("passWord"));
                return account;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account checkAccount(String userName) throws SQLException {

        try {
            Connection connection = JDBCConnection.JDBCConnection();
            String sql = "select * from account where userName = ?";
            Account account = new Account();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                account.setUserName(rs.getString("userName"));
                account.setPassWord(rs.getString("passWord"));
                return account;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addAccount(Account account) throws SQLException {
        Connection connection = JDBCConnection.JDBCConnection();
        String sql = "Insert into account(userName, passWord)"
                + "Values(?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getUserName());
            preparedStatement.setString(2, account.getPassWord());
            int rs = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
