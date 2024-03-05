package lk.ijse.bookworm_lms.bo.custom.impl;

import lk.ijse.bookworm_lms.bo.custom.BranchBO;
import lk.ijse.bookworm_lms.dao.DAOFactory;
import lk.ijse.bookworm_lms.dao.custom.BranchDAO;
import lk.ijse.bookworm_lms.dto.BranchDTO;
import lk.ijse.bookworm_lms.entity.Branch;

import java.util.List;

public class BranchBOImpl implements BranchBO {
    private final BranchDAO branchDAO = (BranchDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BRANCH);

    @Override
    public boolean save(BranchDTO dto) throws Exception {
        return branchDAO.save(new Branch(
                dto.getId(),
                dto.getName(),
                dto.getManager(),
                dto.getAddress(),
                dto.getEmail()
        ));
    }

    @Override
    public boolean update(String id,BranchDTO dto) throws Exception {
        return branchDAO.update(id,new Branch(
                dto.getName(),
                dto.getManager(),
                dto.getAddress(),
                dto.getEmail()
        ));
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public BranchDTO search(String id) throws Exception {
        return null;
    }

    @Override
    public List<BranchDTO> getAll() throws Exception {
        return null;
    }
}
