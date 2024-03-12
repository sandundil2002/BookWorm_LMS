package lk.ijse.bookworm_lms.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.bookworm_lms.dao.CrudDAO;
import lk.ijse.bookworm_lms.dto.TransactionDTO;
import lk.ijse.bookworm_lms.entity.Transaction;

public interface TransactionDAO extends CrudDAO<Transaction> {

    ObservableList<Transaction> getUserTransaction(String user);
}