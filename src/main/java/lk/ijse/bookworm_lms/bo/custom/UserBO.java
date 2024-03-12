package lk.ijse.bookworm_lms.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.bookworm_lms.bo.SuperBO;
import lk.ijse.bookworm_lms.dto.UserDTO;
import lk.ijse.bookworm_lms.entity.Admin;
import lk.ijse.bookworm_lms.entity.User;

public interface UserBO extends SuperBO {

    boolean saveUser(UserDTO dto) throws Exception;

    boolean updateUser(String id,UserDTO dto) throws Exception;

    boolean deleteUser(String id) throws Exception;

    UserDTO searchUser(String id) throws Exception;

    ObservableList<UserDTO> getAllUsers() throws Exception;

    User searchUser(String name, String password) throws Exception;

    User searchUserId(String name) throws Exception;

}
