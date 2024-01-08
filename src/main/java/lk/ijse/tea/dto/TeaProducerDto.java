package lk.ijse.tea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeaProducerDto {

    private String Producer_id;
    private String User_name;
    private String Name;
    private String Address;
    private String NIC;
    private String Contact_no;
    private Date Join_date;
    private String email;

}
