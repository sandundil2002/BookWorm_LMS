package lk.ijse.bookworm_lms.dao.custom;

import lk.ijse.bookworm_lms.dao.CrudDAO;
import lk.ijse.bookworm_lms.entity.User;

public interface UserDAO extends CrudDAO<User> {

    User searchUser(String name, String password);

}
