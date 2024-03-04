package lk.ijse.bookworm_lms.bo.custom;

import lk.ijse.bookworm_lms.bo.CrudBO;
import lk.ijse.bookworm_lms.dto.UserDTO;
import lk.ijse.bookworm_lms.entity.Admin;
import lk.ijse.bookworm_lms.entity.User;

public interface UserBO extends CrudBO<UserDTO> {

    User searchUser(String name, String password);

}
