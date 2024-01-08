package lk.ijse.tea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttendanceDto {

        private String Att_id;
        private String Emp_id;
        //private String Sal_id;
        private String Time_in;
        //private Time Time_out;
        private String Work_hours;
}
