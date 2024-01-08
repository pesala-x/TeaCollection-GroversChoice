package lk.ijse.tea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDto {
    private String Emp_id;
    private String User_name;
    private String First_name;
    private String Last_name;
    private String Job_role;
    private String Contact_no;
    private String Address;
    private String Basic_Pay;
}
