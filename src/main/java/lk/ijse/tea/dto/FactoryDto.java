package lk.ijse.tea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FactoryDto {

    private String Factory_id;
    private String User_name;
    private String Name;
    private String Address;
    private Date Joined_date;
    private Date Time_period;
}
