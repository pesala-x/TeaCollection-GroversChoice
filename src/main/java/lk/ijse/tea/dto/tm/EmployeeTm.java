package lk.ijse.tea.dto.tm;

import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeTm {
    private String Emp_id;
    private String User_name;
    private String First_name;
    private String Last_name;
    private String Job_role;
    private String Contact_no;
    private String Address;
    private String Basic_Pay;
    private Button btn;
}
