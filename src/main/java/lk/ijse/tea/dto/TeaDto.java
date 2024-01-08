package lk.ijse.tea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeaDto {
    private String T_id;
    private String Weight;
    private String Type;
    private String Monthly_pay_kilo;
    private String Description;
    private String Pay_id;
}
