package lk.ijse.bookworm_lms.bo.custom.impl;

import lk.ijse.bookworm_lms.bo.custom.AdminBO;
import lk.ijse.bookworm_lms.dao.DAOFactory;
import lk.ijse.bookworm_lms.dao.custom.AdminDAO;
import lk.ijse.bookworm_lms.dto.AdminDTO;
import lk.ijse.bookworm_lms.entity.Admin;

import java.util.List;

public class AdminBOImpl implements AdminBO {

    private final AdminDAO adminDAO = (AdminDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ADMIN);
    @Override
    public boolean save(AdminDTO dto) throws Exception {
        return adminDAO.save(new Admin(
                dto.getName(),
                dto.getPassword()
        ));
    }

    @Override
    public boolean update(AdminDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public List<AdminDTO> getAll() throws Exception {
        return null;
    }
}
