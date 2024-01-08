package lk.ijse.tea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryDto {
    private String Sal_id;
    private String Emp_id;
    private int Attendance_pay;
    private int Total_payment;
}
