package lk.ijse.tea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FertilizerEquipmentDto {
    private String Eq_id;
    private String User_name;
    private String Pay_id;
    private String Name;
    private String Description;
    private String Unit_price;
}
