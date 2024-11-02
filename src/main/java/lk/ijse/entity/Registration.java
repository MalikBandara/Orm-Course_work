package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.CascadeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Registration {
    @Id
    private int registrationId;

    private double advanced;

    @ManyToOne(cascade = CascadeType.ALL) // Cascade all operations
    private Courses courses;

    @ManyToOne(cascade = CascadeType.ALL) // Cascade all operations
    private Student student;
}
