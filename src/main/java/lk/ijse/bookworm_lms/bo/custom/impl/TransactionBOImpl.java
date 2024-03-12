package lk.ijse.bookworm_lms.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.bookworm_lms.bo.custom.TransactionBO;
import lk.ijse.bookworm_lms.dao.DAOFactory;
import lk.ijse.bookworm_lms.dao.custom.TransactionDAO;
import lk.ijse.bookworm_lms.dto.BookDTO;
import lk.ijse.bookworm_lms.dto.TransactionDTO;
import lk.ijse.bookworm_lms.entity.Book;
import lk.ijse.bookworm_lms.entity.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionBOImpl implements TransactionBO {

    private final TransactionDAO transactionDAO = (TransactionDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TRANSACTION);

    @Override
    public boolean saveTransaction(TransactionDTO dto) throws Exception {
        return transactionDAO.save(new Transaction(
                dto.getUserName(),
                dto.getBookTitle(),
                dto.getBranch(),
                dto.getBorrowing(),
                dto.getReturning()
        ));
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

    @Override
    public ObservableList<TransactionDTO> getUserTransaction(String user) {
        List<Transaction> transactionList = transactionDAO.getUserTransaction(user);
        List<TransactionDTO> transactionDTOS = new ArrayList<>();
        for (Transaction transaction : transactionList) {
            transactionDTOS.add(new TransactionDTO(
                    transaction.getId(),
                    transaction.getBranch(),
                    transaction.getBookTitle(),
                    transaction.getUserName(),
                    transaction.getBorrowing(),
                    transaction.getReturning()
            ));
        }
        return FXCollections.observableArrayList(transactionDTOS);
    }
}
