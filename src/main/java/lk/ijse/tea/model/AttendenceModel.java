package lk.ijse.tea.model;

import lk.ijse.tea.db.DbConnection;
import lk.ijse.tea.dto.AttendanceDto;
import lk.ijse.tea.dto.EmployeeDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendenceModel {
    public String generateNextAttendenceId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT Att_id FROM attendance ORDER BY Att_id DESC LIMIT 1";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();
        String currentAtt_id = "A001";
        if (resultSet.next()) {
            currentAtt_id = resultSet.getString(1);
            return splitOrderId(currentAtt_id);
        }

        return currentAtt_id;
    }

    private String splitOrderId(String currentOrderId) {
        if(currentOrderId != null) {
            String[] split = currentOrderId.split("A");
            int id = Integer.parseInt(split[1]);
            id ++;  //9
            return "A00" + id;
        }
        return "A001";
    }

    public boolean setAttendaance(AttendanceDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into attendance values (?,?,?,?)");
        preparedStatement.setString(1,dto.getAtt_id());
        preparedStatement.setString(2,dto.getEmp_id());
        preparedStatement.setString(3,dto.getTime_in());
        preparedStatement.setString(4,dto.getWork_hours());

        return preparedStatement.executeUpdate() > 0;

    }

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
