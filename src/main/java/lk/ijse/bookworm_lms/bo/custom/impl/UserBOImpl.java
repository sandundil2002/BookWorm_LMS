package lk.ijse.bookworm_lms.bo.custom.impl;

import lk.ijse.bookworm_lms.bo.custom.UserBO;
import lk.ijse.bookworm_lms.dao.DAOFactory;
import lk.ijse.bookworm_lms.dao.custom.UserDAO;
import lk.ijse.bookworm_lms.dto.UserDTO;
import lk.ijse.bookworm_lms.entity.User;

import java.util.List;

public class UserBOImpl implements UserBO {
    private final UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public boolean save(UserDTO dto) throws Exception {
        return userDAO.save(new User(
                dto.getName(),
                dto.getEmail(),
                dto.getPassword())
        );
    }

    @Override
    public boolean update(UserDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public List<UserDTO> getAll() throws Exception {
        return null;
    }
}
