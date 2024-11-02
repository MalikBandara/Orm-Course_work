package lk.ijse.dto;

import lk.ijse.entity.Student;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

    private String username;
    private String password;
    private String role;
    private List<Student> students;
}
