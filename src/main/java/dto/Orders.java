package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Orders {
    private String id;
    private String item;
    private String price;
    private String name;
    private String quantity;
    private String total;
}
