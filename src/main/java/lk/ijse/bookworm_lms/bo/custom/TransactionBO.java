package lk.ijse.bookworm_lms.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.bookworm_lms.bo.SuperBO;
import lk.ijse.bookworm_lms.dto.TransactionDTO;

public interface TransactionBO extends SuperBO {

    boolean saveTransaction(TransactionDTO dto) throws Exception;

    boolean updateTransaction(String id,TransactionDTO dto) throws Exception;

    boolean deleteTransaction(String id) throws Exception;

    TransactionDTO searchTransaction(String id) throws Exception;

    ObservableList<TransactionDTO> getAllTransaction() throws Exception;

    ObservableList<TransactionDTO> getUserTransaction(String user, String status) throws Exception;

    boolean updateStatus(int id,String status) throws Exception ;

}
