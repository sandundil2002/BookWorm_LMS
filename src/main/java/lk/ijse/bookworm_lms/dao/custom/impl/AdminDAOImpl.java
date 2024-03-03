package lk.ijse.bookworm_lms.dao.custom.impl;

import lk.ijse.bookworm_lms.config.SessionFactoryConfig;
import lk.ijse.bookworm_lms.dao.custom.AdminDAO;
import lk.ijse.bookworm_lms.entity.Admin;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AdminDAOImpl implements AdminDAO {
    @Override
    public boolean save(Admin addAdmin){
        Session saveSession = SessionFactoryConfig.getInstance().getSession();
        Transaction saveTransaction = saveSession.beginTransaction();
        saveSession.persist(addAdmin);
        saveTransaction.commit();
        saveSession.close();
        return true;
    }

    @Override
    public boolean delete(Admin admin) throws Exception {
        return false;
    }

    @Override
    public boolean update(Admin admin) throws Exception {
        return false;
    }

    @Override
    public List<Admin> getAll() throws Exception {
        return null;
    }
}
