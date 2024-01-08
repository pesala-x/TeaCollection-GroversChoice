package lk.ijse.tea.model;

import lk.ijse.tea.db.DbConnection;
import lk.ijse.tea.dto.AttendanceDto;
import lk.ijse.tea.dto.TeaDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeaModel {


    public static boolean saveTea(TeaDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("insert into tea values (?,?,?,?,?,?)");
        preparedStatement.setString(1,dto.getT_id());
        preparedStatement.setString(2, String.valueOf(dto.getWeight()));
        preparedStatement.setString(3,dto.getType());
        preparedStatement.setString(4, String.valueOf(dto.getMonthly_pay_kilo()));
        preparedStatement.setString(5,dto.getDescription());
        preparedStatement.setString(6,dto.getPay_id());

        return preparedStatement.executeUpdate() > 0;

    }

    public String generateNextTeaId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT T_id FROM tea ORDER BY T_id DESC LIMIT 1";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();
        String currentT_id = "T001";
        if (resultSet.next()) {
            currentT_id = resultSet.getString(1);
            return splitOrderId(currentT_id);
        }
        return currentT_id;
    }
    private String splitOrderId(String currentT_id) {
        if(currentT_id != null) {
            String[] split = currentT_id.split("T");
            int id = Integer.parseInt(split[1]);
            id ++;  //9
            return "T00" + id;
        }
        return "T001";
    }

    public List<TeaDto> getAllTea() throws SQLException {
        Connection connection =DbConnection.getInstance().getConnection();
        String sql ="SELECT * FROM tea ";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        List<TeaDto> list = new ArrayList<>();

        while (resultSet.next()){
            TeaDto dto = new TeaDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
            list.add(dto);
        }
        return list;
    }
    //

    public List<AttendanceDto> getAllAttendence() throws SQLException {
        Connection connection =DbConnection.getInstance().getConnection();
        String sql ="SELECT * FROM attendance ";
        PreparedStatement psrm = connection.prepareStatement(sql);
        ResultSet resultSet = psrm.executeQuery();

        List<AttendanceDto> list = new ArrayList<>();

        while (resultSet.next()){
            AttendanceDto dto = new AttendanceDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            );
            list.add(dto);
        }
        return list;
    }
}
