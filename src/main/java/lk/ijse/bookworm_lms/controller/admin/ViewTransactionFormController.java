package lk.ijse.bookworm_lms.controller.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bookworm_lms.bo.BOFactory;
import lk.ijse.bookworm_lms.bo.custom.TransactionBO;
import lk.ijse.bookworm_lms.controller.user.UserLoginFormController;
import lk.ijse.bookworm_lms.dto.TransactionDTO;

public class ViewTransactionFormController {

    @FXML
    private TableColumn<?, ?> colBook;

    @FXML
    private TableColumn<?, ?> colBorrow;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colReturn;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colUser;

    @FXML
    private Label lblTitle;

    @FXML
    private TableView<TransactionDTO> tblTransaction;

    private final TransactionBO transactionBO = (TransactionBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.TRANSACTION);

    public void initialize(){
        lblTitle.setText(AdminDashboardFormController.branchName+" Branch Transactions");
        loadAllTransactions();
        setCellValueFactory();
    }

    @FXML
    private void btnNotReturnOnAction() {

    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBook.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        colUser.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colBorrow.setCellValueFactory(new PropertyValueFactory<>("borrowing"));
        colReturn.setCellValueFactory(new PropertyValueFactory<>("returning"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void loadAllTransactions(){
        try {
            tblTransaction.setItems(transactionBO.getBranchTransaction(AdminDashboardFormController.branchName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
