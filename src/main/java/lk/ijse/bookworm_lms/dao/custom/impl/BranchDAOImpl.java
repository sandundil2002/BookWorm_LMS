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
        Transaction saveBranch = saveSession.beginTransaction();
        saveSession.persist(addBranch);
        saveBranch.commit();
        saveSession.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session deleteSession = SessionFactoryConfig.getInstance().getSession();
        Transaction deleteTransaction = deleteSession.beginTransaction();
        Branch deleteBranch = deleteSession.get(Branch.class, id);
        if (deleteBranch != null){
            deleteSession.remove(deleteBranch);
            deleteTransaction.commit();
            deleteSession.close();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(String id , Branch dto) throws Exception {
        Session updateSession = SessionFactoryConfig.getInstance().getSession();
        Transaction updateTransaction = updateSession.beginTransaction();
        Branch existingBranch = updateSession.get(Branch.class, id);
        if (existingBranch!= null) {
            existingBranch.setManager(dto.getManager());
            existingBranch.setName(dto.getName());
            existingBranch.setAddress(dto.getAddress());
            existingBranch.setEmail(dto.getEmail());
            updateSession.merge(existingBranch);
        } else {
            updateTransaction.commit();
            updateSession.close();
            return false;
        }
        updateTransaction.commit();
        updateSession.close();
        return true;
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
