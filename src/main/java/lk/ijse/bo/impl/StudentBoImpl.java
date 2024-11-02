package lk.ijse.bo.impl;

import lk.ijse.bo.StudentBo;
import lk.ijse.dao.DaoFactory;
import lk.ijse.dao.DaoType;
import lk.ijse.dao.StudentDao;
import lk.ijse.dto.StudentDTO;
import lk.ijse.entity.Student;
import lk.ijse.entity.User;

import java.util.List;

public class StudentBoImpl implements StudentBo {


    StudentDao studentDao = (StudentDao) DaoFactory.getInstance().getDao(DaoType.Student);
    @Override
    public boolean addStudent(StudentDTO student) {

     return  studentDao.save(new Student(student.getStudentId(),student.getStudentName(),student.getStudentAddress(),student.getStudentPhone(),student.getStudentEmail(),student.getUserid()));

    }

    @Override
    public List<User> getUserIds() {
       return studentDao.getid();
    }
}
