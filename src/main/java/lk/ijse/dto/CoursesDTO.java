package lk.ijse.dto;
import lk.ijse.entity.Registration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CoursesDTO {

    private String courseId;
    private String courseName;
    private String duration;
    private double coursePrice;
    private List<Registration> registrations;
}
