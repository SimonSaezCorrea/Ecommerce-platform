package demo.schoolar.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    @NotNull
    private String name;
    @NotNull
    private String tenant;
}
