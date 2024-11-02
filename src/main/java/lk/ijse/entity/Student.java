package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    private int StudentId;
    private String StudentName;
    private String StudentAddress;
    private String StudentPhone;
    private String StudentEmail;

    @ManyToOne
    private User userid;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL) // Cascade all operations
    private List<Registration> registrations;
}
