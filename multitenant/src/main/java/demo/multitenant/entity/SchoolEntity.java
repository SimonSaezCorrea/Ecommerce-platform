package demo.multitenant.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "school")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String phone;
}
