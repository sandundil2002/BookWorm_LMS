package lk.ijse.bookworm_lms.controller.user;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bookworm_lms.bo.BOFactory;
import lk.ijse.bookworm_lms.bo.custom.UserBO;
import lk.ijse.bookworm_lms.entity.User;

import java.io.IOException;
import java.util.regex.Pattern;

public class UserLoginFormController {

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;

    private final UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    @FXML
    private void btnLoginOnAction() {
        if (validateAdmin()){
            searchUser();
        }
    }

    @FXML
    private void btnSignupOnAction() {
        pane.getChildren().clear();
        try {
            AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/user/userSignupForm.fxml"));
            pane.getChildren().add(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private void searchUser(){
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        try {
            User user = userBO.searchUser(username, password);
            if (user == null){
                new Alert(Alert.AlertType.WARNING,"Incorrect username or password").show();
            } else {
                loadDashboard();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING,"Incorrect username or password").show();
        }
    }

    private void loadDashboard(){
        try {
            AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/user/userDashboardForm.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) pane.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("User Dashboard");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            new Alert(Alert.AlertType.WARNING,e.getMessage()).show();
        }
    }

    private boolean validateAdmin(){
        String name = txtUsername.getText();
        boolean isFirstNameValidated = Pattern.compile("^[A-Za-z]{1,20}$").matcher(name).matches();

        if (!isFirstNameValidated) {
            new Alert(Alert.AlertType.WARNING, "Please enter a valid user name").show();
            txtUsername.setStyle("-fx-border-color:#ff0000;");
            txtUsername.requestFocus();
            return false;
        }

        String password = txtPassword.getText();
        boolean isPasswordValidated = Pattern.compile("^[A-Za-z0-9+_.-]{4,20}$").matcher(password).matches();

        if (!isPasswordValidated) {
            new Alert(Alert.AlertType.WARNING, "Please enter a valid password").show();
            txtPassword.setStyle("-fx-border-color:#ff0000;");
            txtPassword.requestFocus();
            return false;
        }
        return true;
    }
}
