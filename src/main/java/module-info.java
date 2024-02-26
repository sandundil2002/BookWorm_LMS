module lk.ijse.bookworm_lms {
    requires javafx.controls;
    requires javafx.fxml;


    opens lk.ijse.bookworm_lms to javafx.fxml;
    exports lk.ijse.bookworm_lms;
}