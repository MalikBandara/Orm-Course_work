package lk.ijse.bo;

import lk.ijse.dto.RegistrationDTO;
import lk.ijse.entity.Courses;
import lk.ijse.entity.Student;


import java.util.List;

public interface RegistrationBo extends SuperBo{
    boolean saveRegistration(RegistrationDTO registrationDTO);

    List<Courses> getCourseId();

    List<Student> getStudentId();

    RegistrationDTO searchRegistrations(String id);

    boolean deleteRegistration(String id);
}

