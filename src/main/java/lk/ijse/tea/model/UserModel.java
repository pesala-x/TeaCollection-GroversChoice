package lk.ijse.tea.model;

import lk.ijse.tea.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {

    public static boolean verifyCredential(String username, String password){
        try {
            DbConnection instance = DbConnection.getInstance();
            Connection connection = instance.getConnection();

            String sql = "select Password FROM users WHERE User_name = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                if (password.equals(resultSet.getString(1))){
                    return true;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
