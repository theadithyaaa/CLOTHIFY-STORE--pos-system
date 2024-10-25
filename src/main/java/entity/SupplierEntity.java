package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity
@Table(name = "Supplier")
public class SupplierEntity {
    @Id
    private String id;
    private String name;
    private String company;
    private String email;
}
