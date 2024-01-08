package lk.ijse.tea.model;

import lk.ijse.tea.db.DbConnection;
import lk.ijse.tea.dto.FactoryDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FactoryModel {
    public boolean deleteFactory(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "DELETE FROM factory WHERE Factory_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;
    }//0766585385
/*
    public List<FactoryDto> getAllFactories() throws SQLException {
        Connection connection =DbConnection.getInstance().getConnection();
        String sql ="SELECT * FROM factroy ";
        PreparedStatement psrm = connection.prepareStatement(sql);
        ResultSet resultSet = psrm.executeQuery();

        List<FactoryDto> list = new ArrayList<>();

        while (resultSet.next()){
            FactoryDto dto = new FactoryDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDate(5),
                    resultSet.getDate(6)
            );
            list.add(dto);
        }
        return list;
    }
*/

    public boolean saveFactory(FactoryDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO factory VALUES (?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getFactory_id());
        pstm.setString(2,dto.getUser_name());
        pstm.setString(3,dto.getName());
        pstm.setString(4,dto.getAddress());
        pstm.setDate(5, dto.getJoined_date());
        pstm.setDate(6, dto.getTime_period());

        int i = pstm.executeUpdate();

        return i>0;
    }

    public boolean updateFactory(FactoryDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "UPDATE factory SET User_name = ?,Name = ?,Address = ?,Joined_date = ?,Time_period = ? WHERE Factory_id = ?";
        PreparedStatement pstm =connection.prepareStatement(sql);

        pstm.setString(1, dto.getFactory_id());
        pstm.setString(2, dto.getUser_name());
        pstm.setString(3, dto.getName());
        pstm.setString(4, dto.getAddress());
        pstm.setDate(5,dto.getJoined_date());
        pstm.setDate(6,dto.getTime_period());

        int i = pstm.executeUpdate();

        return i>0;
    }

    public List<FactoryDto> getAllFactories() throws SQLException {
        Connection connection =DbConnection.getInstance().getConnection();
        String sql ="SELECT * FROM factory";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        List<FactoryDto> list = new ArrayList<>();
        while (resultSet.next()){
            FactoryDto dto = new FactoryDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDate(5),
                    resultSet.getDate(6));
            list.add(dto);
        }
        return list;
    }
}
