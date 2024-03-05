package lk.ijse.bookworm_lms.dao.custom.impl;

import lk.ijse.bookworm_lms.config.SessionFactoryConfig;
import lk.ijse.bookworm_lms.dao.custom.BranchDAO;
import lk.ijse.bookworm_lms.entity.Branch;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BranchDAOImpl implements BranchDAO {

    @Override
    public boolean save(Branch addBranch) throws Exception {
        Session saveSession = SessionFactoryConfig.getInstance().getSession();
        Transaction saveTransaction = saveSession.beginTransaction();
        saveSession.persist(addBranch);
        saveTransaction.commit();
        saveSession.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public boolean update(Branch dto) throws Exception {
        return false;
    }

    @Override
    public Branch search(String id) throws Exception {
        return null;
    }

    @Override
    public List<Branch> getAll() throws Exception {
        return null;
    }
}
