package lk.ijse.tea.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class TeaTm {
    private String T_id;
    private String Weight;
    private String Type;
    private String Monthly_pay_kilo;
    private String Description;
    private String Pay_id;
}
