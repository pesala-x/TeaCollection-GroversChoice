package lk.ijse.tea.model;

import lk.ijse.tea.db.DbConnection;
import lk.ijse.tea.dto.FertilizerEquipmentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FertilizerEquipmentModel {


    public static boolean saveFertilizer(FertilizerEquipmentDto dto) throws SQLException {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into fertilizer_equipment values (?,?,?,?,?,?)");
            preparedStatement.setString(1,dto.getEq_id());
            preparedStatement.setString(2,dto.getUser_name());
            preparedStatement.setString(3,dto.getPay_id());
            preparedStatement.setString(4,dto.getName());
            preparedStatement.setString(5,dto.getDescription());
            preparedStatement.setString(6,dto.getUnit_price());

            return preparedStatement.executeUpdate() > 0;
        }

    public String generateNextFertilizerId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT T_id FROM fertilizer_equipments ORDER BY T_id DESC LIMIT 1";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();
        String currentT_id = "e001";
        if (resultSet.next()) {
            currentT_id = resultSet.getString(1);
            return splitOrderId(currentT_id);
        }
        return currentT_id;
    }
    private String splitOrderId(String currentT_id) {
        if(currentT_id != null) {
            String[] split = currentT_id.split("e");
            int id = Integer.parseInt(split[1]);
            id ++;  //9
            return "e00" + id;
        }
        return "e001";
    }
}
