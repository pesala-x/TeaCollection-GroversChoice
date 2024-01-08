package lk.ijse.tea.model;

import lk.ijse.tea.db.DbConnection;
import lk.ijse.tea.dto.EmployeeDto;
import lk.ijse.tea.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {

    public static boolean verifyCredential(String username, String password){
        try {
            DbConnection instance = DbConnection.getInstance();
            Connection connection = instance.getConnection();

            String sql = "select * FROM users WHERE User_name = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                if (password.equals(resultSet.getString(2))){
                    return true;
                }else {
                    return false;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public static String getUsername(String text) {
        return null;
    }

    public static boolean saveUser(UserDto userDTO) {
        return false;
    }

    public boolean signUser(UserDto dto) throws SQLException {
        Connection connection =DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO users VALUES (?,?,?)";
        PreparedStatement pstm =connection.prepareStatement(sql);

        pstm.setString(1, dto.getUser_name());
        pstm.setString(2, dto.getPassword());
        pstm.setString(3, dto.getEmail());

        int i = pstm.executeUpdate();

        return i>0;
    }

    public UserDto getEmail(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE User_name = ?";
        ResultSet resultSet = null;

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,username);
        try {
            resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                return new UserDto(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public boolean updatePassword(String username, String text) throws SQLException {
        String sql = "UPDATE users SET Password=? WHERE User_name=?";
        try (PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql)) {
            pstm.setString(1,text);
            pstm.setString(2,username);
            int rows = pstm.executeUpdate();
            if (rows > 0) {
                return true;
            }
        }
        return false;
    }
}
