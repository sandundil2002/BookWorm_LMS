package lk.ijse.bookworm_lms.bo.custom.impl;

import lk.ijse.bookworm_lms.bo.custom.UserBO;
import lk.ijse.bookworm_lms.dto.UserDTO;

import java.util.List;

public class UserBOImpl implements UserBO {
    @Override
    public boolean save(UserDTO dto) throws Exception {
        return false;
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
