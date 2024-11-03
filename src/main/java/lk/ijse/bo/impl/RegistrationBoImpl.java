package lk.ijse.bo.impl;

import lk.ijse.bo.RegistrationBo;
import lk.ijse.dao.DaoFactory;
import lk.ijse.dao.DaoType;
import lk.ijse.dao.RegistrationDao;
import lk.ijse.dto.RegistrationDTO;
import lk.ijse.entity.Courses;
import lk.ijse.entity.Registration;
import lk.ijse.entity.Student;


import java.util.List;

public class RegistrationBoImpl implements RegistrationBo {

    RegistrationDao registrationDao = (RegistrationDao) DaoFactory.getInstance().getDao(DaoType.Registration);
    @Override
    public boolean saveRegistration(RegistrationDTO registrationDTO) {
       return registrationDao.save(new Registration(registrationDTO.getRegistrationId(),registrationDTO.getAdvanced(),registrationDTO.getDate(),registrationDTO.getCourses(),registrationDTO.getStudent()));
    }

    @Override
    public List<Courses> getCourseId() {
        List<Courses> ids = registrationDao.getIds();
        return ids;
    }

    @Override
    public List<Student> getStudentId() {
       return registrationDao.getStudentIds();
    }

    @Override
    public RegistrationDTO searchRegistrations(String id) {
        try {
            Registration registration = registrationDao.find(id);

            RegistrationDTO registrationDTO = new RegistrationDTO(registration.getRegistrationId(), registration.getAdvanced(), registration.getDate(), registration.getCourses(), registration.getStudent());
            return registrationDTO;
        }catch (Exception e){
            return null;
        }



    }

    @Override
    public boolean deleteRegistration(String id) {
     return registrationDao.delete(id);
    }
}
