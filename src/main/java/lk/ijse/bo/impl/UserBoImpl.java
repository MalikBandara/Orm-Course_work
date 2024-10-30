package lk.ijse.bo.impl;

import lk.ijse.bo.UserBo;
import lk.ijse.dao.DaoFactory;
import lk.ijse.dao.DaoType;
import lk.ijse.dao.UserDao;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;

import java.util.ArrayList;
import java.util.List;


public class UserBoImpl implements UserBo {

    UserDao userDao  = (UserDao) DaoFactory.getInstance().getDao(DaoType.User);



    public List<String> getAllRoles() {
        return userDao.getAllRoles();
    }

    @Override
    public List<UserDTO> getUserDetails(UserDTO userDTO) {
        List<UserDTO> userdt = new ArrayList<>();
        List<User> userDetails = userDao.getUserDetails(new User(userDTO.getRole(), userDTO.getUsername(), userDTO.getPassword()));

        for (User user : userDetails){
            UserDTO userDTO1 = new UserDTO(user.getUsername(), user.getPassword(),user.getRole());
            userdt.add(userDTO1);
        }
        return userdt;
    }


}
