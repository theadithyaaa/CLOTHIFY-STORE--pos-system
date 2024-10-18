package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class OrderEntity {
    private String id;
    private String item;
    private Double price;
    private String paytype;
    private Integer quantity;
}
