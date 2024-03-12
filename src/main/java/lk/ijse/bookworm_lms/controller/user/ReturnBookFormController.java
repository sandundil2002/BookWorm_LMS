package lk.ijse.bookworm_lms.controller.user;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bookworm_lms.bo.BOFactory;
import lk.ijse.bookworm_lms.bo.custom.TransactionBO;
import lk.ijse.bookworm_lms.dto.TransactionDTO;

public class ReturnBookFormController {

    @FXML
    private TableColumn<?, ?> colBorrow;

    @FXML
    private TableColumn<?, ?> colBranch;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colReturn;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableColumn<?, ?> colUser;

    @FXML
    private TableView<TransactionDTO> tblBooks;

    private final TransactionBO transactionBO = (TransactionBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.TRANSACTION);

    public void initialize(){
        loadAllTransactions();
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBranch.setCellValueFactory(new PropertyValueFactory<>("branch"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        colUser.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colBorrow.setCellValueFactory(new PropertyValueFactory<>("borrowing"));
        colReturn.setCellValueFactory(new PropertyValueFactory<>("returning"));
    }

    private void loadAllTransactions(){
        try {
            String status = "Return";
            tblBooks.setItems(transactionBO.getUserTransaction(UserLoginFormController.member,status));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
