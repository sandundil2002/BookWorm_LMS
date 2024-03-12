package lk.ijse.bookworm_lms.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.bookworm_lms.bo.custom.TransactionBO;
import lk.ijse.bookworm_lms.dto.TransactionDTO;

public class TransactionBOImpl implements TransactionBO {
    @Override
    public boolean saveTransaction(TransactionDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean updateTransaction(String id, TransactionDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteTransaction(String id) throws Exception {
        return false;
    }

    @Override
    public TransactionDTO searchTransaction(String id) throws Exception {
        return null;
    }

    @Override
    public ObservableList<TransactionDTO> getAllTransaction() throws Exception {
        return null;
    }
}
