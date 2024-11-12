package lk.ijse.dto.tm;

import lk.ijse.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentTm2 {
    private int StudentId;
    private String StudentName;
    private User userid;
}
