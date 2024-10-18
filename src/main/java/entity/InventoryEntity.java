package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class InventoryEntity {
    private String id;
    private String name;
    private String category;
    private String size;
    private Integer quantity;
}
