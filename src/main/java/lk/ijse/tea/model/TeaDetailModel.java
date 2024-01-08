package lk.ijse.tea.model;

import lk.ijse.tea.db.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeaDetailModel {
    public String generateNextTeaDetailId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT T_id FROM attendance ORDER BY T_id DESC LIMIT 1";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();
        String currentT_id = "T001";
        if (resultSet.next()) {
            currentT_id = resultSet.getString(1);
            return splitOrderId(currentT_id);
        }

        /*public List<AttendanceDto> loadAllEmployees () {

            return null;
        }*/
        return currentT_id;

    }
    private String splitOrderId(String currentOrderId) {
        if(currentOrderId != null) {
            String[] split = currentOrderId.split("T");
            int id = Integer.parseInt(split[1]);
            id ++;  //9
            return "T00" + id;
        }
        return "T001";
    }
}
