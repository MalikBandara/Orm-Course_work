package lk.ijse.bo.impl;

import lk.ijse.bo.CourseBo;
import lk.ijse.dao.CourseDao;
import lk.ijse.dao.DaoFactory;
import lk.ijse.dao.DaoType;
import lk.ijse.dto.CoursesDTO;
import lk.ijse.entity.Courses;

public class CourseBoImpl implements CourseBo {

    CourseDao courseDao = (CourseDao) DaoFactory.getInstance().getDao(DaoType.Course);
    @Override
    public boolean saveCourses(CoursesDTO coursesDTO) {
        boolean save = courseDao.save(new Courses(coursesDTO.getCourseId(), coursesDTO.getCourseName(), coursesDTO.getDuration(), coursesDTO.getCoursePrice()));
        return save;
    }
}
