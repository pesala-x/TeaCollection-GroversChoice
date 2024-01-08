package lk.ijse.tea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FertilizerEquipmentDetailsDto {
    private String Eq_id;
    private String Producer_id;
    private String Pay_id;
    private String Name;
    private String Description;
    private int Unit_price;
}
