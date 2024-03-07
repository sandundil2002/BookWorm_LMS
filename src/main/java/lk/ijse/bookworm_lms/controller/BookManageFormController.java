package lk.ijse.bookworm_lms.controller;

import javafx.application.Platform;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bookworm_lms.bo.BOFactory;
import lk.ijse.bookworm_lms.bo.custom.BookBO;

import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;
import java.util.regex.Pattern;

public class BookManageFormController {

    @FXML
    private AnchorPane pane;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colBranchId;

    @FXML
    private TableColumn<?, ?> colGenre;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colTimeStamp;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblTitle;

    @FXML
    private TableView<?> tblCustomer;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBranch;

    @FXML
    private TextField txtGenre;

    @FXML
    private TextField txtSearch;

    @FXML
    private TextField txtTitle;

    private final BookBO bookBO = (BookBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BOOK);

    private final String branchName = AdminDashboardFormController.branchName;

    public void initialize(){
        //updateRealTime(lblTime);
        lblTitle.setText("Welcome To "+branchName+" Branch");
        txtBranch.setText(branchName);
    }

    @FXML
    private void btnClearOnAction() {
        resetBoarderColour();
        txtSearch.setText("");
        txtBranch.setText("");
        txtTitle.setText("");
        txtAuthor.setText("");
        txtGenre.setText("");
    }

    @FXML
    private void btnDeleteOnAction() {

    }

    @FXML
    private void btnSaveOnAction() {

    }

    @FXML
    private void btnSearchOnAction() {
        if (validateBook()){

        }
    }

    @FXML
    private void btnUpdateOnAction() {

    }

    private boolean validateBook(){
        String title = txtTitle.getText();
        boolean isTitleValidated = Pattern.compile("^[A-Za-z]{1,20}$").matcher(title).matches();

        if (!isTitleValidated) {
            new Alert(Alert.AlertType.WARNING, "Please enter a valid book title").show();
            txtTitle.setStyle("-fx-border-color:#ff0000;");
            txtTitle.requestFocus();
            return false;
        }

        String author = txtAuthor.getText();
        boolean isAuthorValidated = Pattern.compile("^[A-Za-z]{1,20}$").matcher(author).matches();

        if (!isAuthorValidated) {
            new Alert(Alert.AlertType.WARNING, "Please enter a valid book author").show();
            txtAuthor.setStyle("-fx-border-color:#ff0000;");
            txtAuthor.requestFocus();
            return false;
        }

        String genre = txtGenre.getText();
        boolean isGenreValidated = Pattern.compile("^[A-Za-z]{1,20}$").matcher(genre).matches();

        if (!isGenreValidated) {
            new Alert(Alert.AlertType.WARNING, "Please enter a valid book genre").show();
            txtGenre.setStyle("-fx-border-color:#ff0000;");
            txtGenre.requestFocus();
            return false;
        }
        return true;
    }

    @FXML
    private void btnBackOnAction() {
        try {
            AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/adminDashboardForm.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) pane.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Admin Dashboard");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            new Alert(Alert.AlertType.WARNING,e.getMessage()).show();
        }
    }

    private void resetBoarderColour(){
        txtSearch.setStyle("-fx-border-color: black");
        txtAuthor.setStyle("-fx-border-color: black");
        txtTitle.setStyle("-fx-border-color: black");
        txtGenre.setStyle("-fx-border-color: black");
    }

    private void updateRealTime(Label label) {
        lblDate.setText(LocalDate.now().toString());
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            String currentTime = LocalDateTime.now().format(timeFormatter);
            Platform.runLater(() -> label.setText(currentTime));
        }, 0, 1, TimeUnit.SECONDS);
    }
}
