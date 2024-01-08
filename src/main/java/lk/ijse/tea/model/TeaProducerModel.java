package lk.ijse.tea.model;

import lk.ijse.tea.db.DbConnection;
import lk.ijse.tea.dto.TeaProducerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeaProducerModel {
    public static TeaProducerDto searchEmployee(String idValue) {


        return null;
    }

    public boolean deleteProducer(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "DELETE FROM tea_producer WHERE Producer_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);
        return pstm.executeUpdate() > 0;
    }

    public boolean saveProducer(TeaProducerDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO tea_producer VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getProducer_id());
        pstm.setString(2, dto.getUser_name());
        pstm.setString(3, dto.getName());
        pstm.setString(4, dto.getAddress());
        pstm.setString(5, dto.getNIC());
        pstm.setString(6, dto.getContact_no());
        pstm.setDate(7,dto.getJoin_date());
        int i = pstm.executeUpdate();

        return i>0;
    }

    public boolean updateProducer(TeaProducerDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "UPDATE tea_producer SET User_name =?,Name =?,Address =?,NIC =?,Contact_no =?,Join_date =? WHERE Producer_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getProducer_id());
        pstm.setString(2, dto.getUser_name());
        pstm.setString(3, dto.getName());
        pstm.setString(4, dto.getAddress());
        pstm.setString(5,dto.getNIC());
        pstm.setString(6, dto.getContact_no());
        pstm.setDate(7,dto.getJoin_date());

        return pstm.executeUpdate()>0;
    }

    public List<TeaProducerDto> getAllProducers() throws SQLException {
        Connection connection =DbConnection.getInstance().getConnection();
        String sql ="SELECT * FROM tea_producer";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        List<TeaProducerDto> list = new ArrayList<>();
        while (resultSet.next()){
            TeaProducerDto dto =new TeaProducerDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getDate(7),
                    null
            );
            list.add(dto);
        }
        return list;
    }
}