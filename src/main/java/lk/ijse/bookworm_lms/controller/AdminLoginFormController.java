package lk.ijse.bookworm_lms.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bookworm_lms.bo.BOFactory;
import lk.ijse.bookworm_lms.bo.custom.AdminBO;
import lk.ijse.bookworm_lms.dto.AdminDTO;

import java.io.IOException;

public class AdminLoginFormController {

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;

    private final AdminBO adminBO = (AdminBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ADMIN);

    public void initialize(){
        addDefaultAdmin();
    }

    @FXML
    private void btnLoginOnAction() {

    }

    @FXML
    private void btnBackOnAction() {
        pane.getChildren().clear();
        try {
            AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/mainLoginForm.fxml"));
            pane.getChildren().add(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addDefaultAdmin(){
        AdminDTO adminDTO = new AdminDTO("sandun","1234");
        try {
            adminBO.save(adminDTO);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}
