package lk.ijse.bookworm_lms.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.bookworm_lms.bo.BOFactory;
import lk.ijse.bookworm_lms.bo.custom.BranchBO;
import lk.ijse.bookworm_lms.dto.BranchDTO;

import java.util.regex.Pattern;

public class AdminDashboardFormController {

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
                } else {
                    new Alert(Alert.AlertType.WARNING, "Branch not found").show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Invalid Branch ID").show();
        }
    }

    @FXML
    private void btnDeleteOnAction() {

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
}
