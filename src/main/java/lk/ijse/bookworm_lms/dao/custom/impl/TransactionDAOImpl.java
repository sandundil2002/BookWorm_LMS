package lk.ijse.bookworm_lms.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.bookworm_lms.config.SessionFactoryConfig;
import lk.ijse.bookworm_lms.dao.custom.TransactionDAO;
import lk.ijse.bookworm_lms.entity.Transaction;
import org.hibernate.Session;

public class TransactionDAOImpl implements TransactionDAO{

    @Override
    public boolean save(Transaction addTransaction) throws Exception {
        Session saveSession = SessionFactoryConfig.getInstance().getSession();
        org.hibernate.Transaction saveBranch = saveSession.beginTransaction();
        saveSession.persist(addTransaction);
        saveBranch.commit();
        saveSession.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public boolean update(String id, Transaction dto) throws Exception {
        return false;
    }

    @Override
    public Transaction search(String id) throws Exception {
        return null;
    }

    @Override
    public ObservableList<Transaction> loadAll() throws Exception {
        return null;
    }
}
