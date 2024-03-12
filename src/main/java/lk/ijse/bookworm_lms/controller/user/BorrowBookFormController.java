package lk.ijse.bookworm_lms.controller.user;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bookworm_lms.bo.BOFactory;
import lk.ijse.bookworm_lms.bo.custom.TransactionBO;
import lk.ijse.bookworm_lms.dto.TransactionDTO;

import java.util.Optional;

public class BorrowBookFormController {

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
        returnBook();
        reload();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBranch.setCellValueFactory(new PropertyValueFactory<>("branch"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        colUser.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colBorrow.setCellValueFactory(new PropertyValueFactory<>("borrowing"));
        colReturn.setCellValueFactory(new PropertyValueFactory<>("returning"));
    }

    private void returnBook(){
        try {
            tblBooks.setOnMouseClicked(event -> {
                TransactionDTO selectedItem = tblBooks.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

                    Optional<ButtonType> result = new Alert(Alert.AlertType.INFORMATION, "Are you sure want to return this Book?", ok, no).showAndWait();
                    if (result.orElse(no) == ok) {
                        updateStatus(selectedItem.getId());
                        reload();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateStatus(int id){
        try {
            String status = "Return";
            transactionBO.updateStatus(id,status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reload() {
        loadAllTransactions();
        setCellValueFactory();
    }

    private void loadAllTransactions(){
        try {
            String status = "Borrow";
            tblBooks.setItems(transactionBO.getUserTransaction(UserLoginFormController.member,status));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
