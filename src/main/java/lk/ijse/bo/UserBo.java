package lk.ijse.bo;
import lk.ijse.dto.UserDTO;
import java.util.List;

public interface UserBo  extends SuperBo{




      List<String> getAllRoles() ;


      List<UserDTO> getUserDetails(UserDTO userDTO);
}
