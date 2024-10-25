package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity(name = "Employee")
public class EmployeeEntity {
    @Id
    private String id;
    private String name;
    private String email;
    private String contact;
    private String company;

}
