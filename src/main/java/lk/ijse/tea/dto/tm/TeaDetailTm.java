package lk.ijse.tea.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeaDetailTm {

    private String TeaDetailId;
    private String TeaType;
    private String TeaRate;
    private String TeaWeight;
    private String TotalWeight;
}
