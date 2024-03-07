package lk.ijse.bookworm_lms.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BranchFormController {

    @FXML
    private AnchorPane pane;

    @FXML
    private TableColumn<?, ?> colAuther;

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
    private TextField txtAuther;

    @FXML
    private TextField txtBranch;

    @FXML
    private TextField txtGenre;

    @FXML
    private TextField txtSearch;

    @FXML
    private TextField txtTitle;

    private final int branchId = AdminDashboardFormController.branchId;

    public void initialize(){
        updateRealTime(lblTime);
        lblTitle.setText("Welcome To Branch "+branchId);
        txtBranch.setText("Branch "+branchId);
    }

    @FXML
    private void btnClearOnAction() {

    }

    @FXML
    private void btnDeleteOnAction() {

    }

    @FXML
    private void btnSaveOnAction() {

    }

    @FXML
    private void btnSearchOnAction() {

    }

    @FXML
    private void btnUpdateOnAction() {

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
