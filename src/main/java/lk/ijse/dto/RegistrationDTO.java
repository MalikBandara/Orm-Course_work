package lk.ijse.dto;
import lk.ijse.entity.Courses;
import lk.ijse.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationDTO {

    private int registrationId;
    private double advanced;
    private Date date;
    private Courses courses;
    private Student student;
}
