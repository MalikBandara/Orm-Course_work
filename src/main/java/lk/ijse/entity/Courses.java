package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Courses {

    @Id
    private String courseId;
    private String courseName;
    private String duration;
    private double coursePrice;

    @OneToMany(mappedBy = "courses", cascade = CascadeType.ALL) // Cascade all operations
    private List<Registration> registrations;
}
