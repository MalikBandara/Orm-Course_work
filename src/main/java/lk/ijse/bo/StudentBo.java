package lk.ijse.bo;


import lk.ijse.dto.StudentDTO;
import lk.ijse.entity.User;

import java.util.List;


public interface StudentBo extends SuperBo {

    public boolean addStudent(StudentDTO student);

    List<User> getUserIds();
}
