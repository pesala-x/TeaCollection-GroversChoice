package lk.ijse.tea.dto.tm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AttendenceTm {
    private String Att_id;
    private String Emp_id;
    private String Time_in;
    private String Work_hours;
}
