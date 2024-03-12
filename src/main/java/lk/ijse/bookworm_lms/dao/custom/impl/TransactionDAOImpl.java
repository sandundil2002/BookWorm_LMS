package lk.ijse.bookworm_lms.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.bookworm_lms.dao.custom.TransactionDAO;
import lk.ijse.bookworm_lms.entity.Transaction;

public class TransactionDAOImpl implements TransactionDAO{

    @Override
    public boolean save(Transaction dto) throws Exception {
        return false;
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
