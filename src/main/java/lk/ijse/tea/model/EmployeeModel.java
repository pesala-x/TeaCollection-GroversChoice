package lk.ijse.tea.model;

import lk.ijse.tea.db.DbConnection;
import lk.ijse.tea.dto.EmployeeDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {
    public static List<EmployeeDto> loadAllEmployeeAttendence() throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM employee";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        List<EmployeeDto> empList = new ArrayList<>();

        while (resultSet.next()) {
            empList.add(new EmployeeDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8)

            ));
        }
        return empList;

    }

    public static EmployeeDto searchEmployee(String Emp_id) throws SQLException {
        Connection connection =DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM employee WHERE Emp_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,Emp_id);

        ResultSet resultSet = pstm.executeQuery();

        EmployeeDto dto =null;

        if (resultSet.next()){
            String id = resultSet.getString(1);
            String User_name = resultSet.getString(2);
            String First_name = resultSet.getString(3);
            String Last_name = resultSet.getString(4);
            String Job_role = resultSet.getString(5);
            String Contact_no = resultSet.getString(6);
            String Address = resultSet.getString(7);
            String Basic_Pay = resultSet.getString(8);

            dto =new EmployeeDto(Emp_id,User_name,First_name,Last_name,Job_role,Contact_no,Address,Basic_Pay);
        }

        return dto;
    }

    public boolean saveEmployee(EmployeeDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO employee VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,dto.getEmp_id());
        pstm.setString(2,dto.getUser_name());
        pstm.setString(3,dto.getFirst_name());
        pstm.setString(4,dto.getLast_name());
        pstm.setString(5,dto.getJob_role());
        pstm.setString(6,dto.getContact_no());
        pstm.setString(7,dto.getAddress());
        pstm.setString(8,dto.getBasic_Pay());

        int i = pstm.executeUpdate();

        return i>0;
    }

    public boolean deleteEmployee(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "DELETE FROM employee WHERE Emp_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        return pstm.executeUpdate()>0;
    }

    public boolean updateEmployee(EmployeeDto dto) throws SQLException {
        Connection connection =DbConnection.getInstance().getConnection();
        String sql ="UPDATE employee SET User_name = ?,First_name = ?,Last_name = ?,Job_role = ?,Contact_no = ?,Address = ?,Basic_Pay = ? WHERE Emp_id = ?";
        PreparedStatement pstm =connection.prepareStatement(sql);

        pstm.setString(8,dto.getEmp_id());
        pstm.setString(2,dto.getFirst_name());
        pstm.setString(1,dto.getUser_name());
        pstm.setString(3,dto.getLast_name());
        pstm.setString(4,dto.getJob_role());
        pstm.setString(5,dto.getContact_no());
        pstm.setString(6,dto.getAddress());
        pstm.setString(7,dto.getBasic_Pay());

        return pstm.executeUpdate()>0;
    }

    public List<EmployeeDto> getAllEmployees() throws SQLException {
        Connection connection =DbConnection.getInstance().getConnection();
        String sql ="SELECT * FROM employee ";
        PreparedStatement psrm = connection.prepareStatement(sql);
        ResultSet resultSet = psrm.executeQuery();

        List<EmployeeDto> list = new ArrayList<>();

        while (resultSet.next()){
            EmployeeDto dto = new EmployeeDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8)
                    );
            list.add(dto);
        }
        return list;
    }
}
