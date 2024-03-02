package lk.ijse.bookworm_lms.dao.custom.impl;

import lk.ijse.bookworm_lms.dao.custom.UserDAO;
import lk.ijse.bookworm_lms.entity.User;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean save(User user) throws Exception {
        return false;
    }

    @Override
    public boolean delete(User user) throws Exception {
        return false;
    }

    @Override
    public boolean update(User user) throws Exception {
        return false;
    }

    @Override
    public List<User> getAll() throws Exception {
        return null;
    }
}
