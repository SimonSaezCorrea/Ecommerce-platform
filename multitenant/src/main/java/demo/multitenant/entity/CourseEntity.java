package demo.multitenant.entity;


import lombok.*;
import javax.persistence.*;

@Entity
@Table(name="course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int id_professor;
    private int id_school;
}
