package lk.ijse.bookworm_lms.bo.custom.impl;

import javafx.collections.ObservableList;
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
    public boolean update(String id , AdminDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public AdminDTO search(String id) throws Exception {
        return null;
    }

    @Override
    public ObservableList<AdminDTO> getAll() throws Exception {
        return null;
    }

    @Override
    public Admin searchAdmin(String name, String password) {
        Admin admin = adminDAO.searchAdmin(name, password);
        if (admin != null){
            return new Admin(
                    admin.getName(),
                    admin.getPassword()
            );
        }
        return null;
    }
}
