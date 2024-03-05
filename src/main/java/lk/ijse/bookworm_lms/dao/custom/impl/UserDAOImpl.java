package lk.ijse.bookworm_lms.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.bookworm_lms.config.SessionFactoryConfig;
import lk.ijse.bookworm_lms.dao.custom.UserDAO;
import lk.ijse.bookworm_lms.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public boolean update(String id , User user) throws Exception {
        return false;
    }

    @Override
    public User search(String id) throws Exception {
        return null;
    }

    @Override
    public ObservableList<User> getAll() throws Exception {
        return null;
    }

    @Override
    public User searchUser(String name, String password) {
        Session searchSession = SessionFactoryConfig.getInstance().getSession();
        Transaction searchTransaction = searchSession.beginTransaction();
        Query<User> query = searchSession.createQuery("FROM User WHERE name = :name AND password = :password", User.class);
        query.setParameter("name", name);
        query.setParameter("password", password);

        User user = query.uniqueResult();
        searchTransaction.commit();
        searchSession.close();

        return user;
    }
}
