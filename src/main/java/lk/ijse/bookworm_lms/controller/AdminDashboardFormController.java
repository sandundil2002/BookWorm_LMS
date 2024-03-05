package lk.ijse.bookworm_lms.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bookworm_lms.bo.BOFactory;
import lk.ijse.bookworm_lms.bo.custom.BranchBO;
import lk.ijse.bookworm_lms.dto.BranchDTO;

import java.util.regex.Pattern;

public class AdminDashboardFormController {

    @FXML
    private TableColumn<?, ?> colClick;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableView<BranchDTO> tblBranch;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtMail;

    @FXML
    private TextField txtManager;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSearch;

    private final BranchBO branchBO = (BranchBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BRANCH);

    public void initialize(){
        reload();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    @FXML
    private void btnSaveOnAction() {
        if (validateBranch()){
            String name = txtName.getText();
            String manager = txtManager.getText();
            String address = txtAddress.getText();
            String email = txtMail.getText();

            BranchDTO branchDTO = new BranchDTO(name,manager,address,email);
            try {
                boolean isSaved = branchBO.save(branchDTO);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Branch Registered Successfully").show();
                    btnClearOnAction();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Branch Registration Failed").show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void btnUpdateOnAction() {
        String id = txtSearch.getText();

        if (Pattern.compile("\\d+").matcher(id).matches() && validateBranch()) {
            String name = txtName.getText();
            String manager = txtManager.getText();
            String address = txtAddress.getText();
            String email = txtMail.getText();

            BranchDTO branchDTO = new BranchDTO(name,manager,address,email);
            try {
                boolean isUpdated = branchBO.update(id,branchDTO);
                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Branch Updated Successfully").show();
                    btnClearOnAction();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Branch not found").show();
                    txtSearch.setStyle("-fx-border-color:#ff0000;");
                    txtSearch.requestFocus();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Invalid Branch ID").show();
            txtSearch.setStyle("-fx-border-color:#ff0000;");
            txtSearch.requestFocus();
        }
    }

    @FXML
    private void btnDeleteOnAction() {
        String id = txtSearch.getText();
        if (Pattern.compile("\\d+").matcher(id).matches()){
            try {
                boolean isDeleted = branchBO.delete(id);
                if (isDeleted) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Branch Delete Successfully").show();
                    btnClearOnAction();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Branch not found").show();
                    txtSearch.setStyle("-fx-border-color:#ff0000;");
                    txtSearch.requestFocus();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }  else {
            new Alert(Alert.AlertType.WARNING, "Invalid Branch ID").show();
            txtSearch.setStyle("-fx-border-color:#ff0000;");
            txtSearch.requestFocus();
        }
    }

    private void loadAllBranches(){
        try {
            tblBranch.setItems(branchBO.getAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnClearOnAction() {
        resetBoarderColour();
        reload();
        txtSearch.setText("");
        txtName.setText("");
        txtManager.setText("");
        txtAddress.setText("");
        txtMail.setText("");
    }

    private boolean validateBranch(){
        String name = txtName.getText();
        boolean isNameValidated = Pattern.compile("^[A-Za-z]{1,20}$").matcher(name).matches();

        if (!isNameValidated) {
            new Alert(Alert.AlertType.WARNING, "Please enter a valid branch name").show();
            txtName.setStyle("-fx-border-color:#ff0000;");
            txtName.requestFocus();
            return false;
        }

        String managerName = txtManager.getText();
        boolean isManagerValidated = Pattern.compile("^[A-Za-z]{1,20}$").matcher(managerName).matches();

        if (!isManagerValidated) {
            new Alert(Alert.AlertType.WARNING, "Please enter a valid manager name").show();
            txtManager.setStyle("-fx-border-color:#ff0000;");
            txtManager.requestFocus();
            return false;
        }

        String address = txtAddress.getText();
        boolean isAddressValidated = Pattern.compile("^[A-z]{1,20}$").matcher(address).matches();
        if (!isAddressValidated) {
            txtAddress.requestFocus();
            txtAddress.setStyle("-fx-border-color:#ff0000;");
            return false;
        }

        String email = txtMail.getText();
        boolean isEmailValidated = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(email).matches();

        if (!isEmailValidated) {
            new Alert(Alert.AlertType.WARNING, "Please enter a valid email").show();
            txtMail.setStyle("-fx-border-color:#ff0000;");
            txtMail.requestFocus();
            return false;
        }
        return true;
    }

    private void reload(){
        loadAllBranches();
        setCellValueFactory();
    }

    private void resetBoarderColour(){
        txtSearch.setStyle("-fx-border-color: black");
        txtName.setStyle("-fx-border-color: black");
        txtManager.setStyle("-fx-border-color: black");
        txtAddress.setStyle("-fx-border-color: black");
        txtMail.setStyle("-fx-border-color: black");
    }
}
