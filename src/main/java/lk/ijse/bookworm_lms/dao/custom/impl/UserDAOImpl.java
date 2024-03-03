package lk.ijse.bookworm_lms.dao.custom.impl;

import lk.ijse.bookworm_lms.config.SessionFactoryConfig;
import lk.ijse.bookworm_lms.dao.custom.UserDAO;
import lk.ijse.bookworm_lms.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean save(User saveUser){
        Session saveSession = SessionFactoryConfig.getInstance().getSession();
        Transaction saveTransaction = saveSession.beginTransaction();
        saveSession.persist(saveUser);
        saveTransaction.commit();
        saveSession.close();
        return true;
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
