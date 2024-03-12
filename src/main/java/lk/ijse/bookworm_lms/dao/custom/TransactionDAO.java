package lk.ijse.bookworm_lms.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.bookworm_lms.dao.CrudDAO;
import lk.ijse.bookworm_lms.entity.Transactions;

public interface TransactionDAO extends CrudDAO<Transactions> {

    ObservableList<Transactions> getUserTransaction(String user, String status);

    boolean updateStatus(int id,String status);
}