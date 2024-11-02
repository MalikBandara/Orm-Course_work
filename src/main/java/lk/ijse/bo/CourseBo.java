package lk.ijse.bo;

import lk.ijse.dto.CoursesDTO;



public interface CourseBo extends SuperBo{
    boolean saveCourses(CoursesDTO coursesDTO);


    CoursesDTO searchCourse(String courseId);

    boolean deleteCourse(String courseIdText);

    boolean updateCourse(CoursesDTO coursesDTO);
}
