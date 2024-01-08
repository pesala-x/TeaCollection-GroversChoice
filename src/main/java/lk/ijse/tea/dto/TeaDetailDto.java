package lk.ijse.tea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class TeaDetailDto {
    private String T_id;
    private String Producer_id;
    private Double Total;
}
