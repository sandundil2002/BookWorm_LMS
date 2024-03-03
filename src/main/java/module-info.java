module lk.ijse.bookworm_lms {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires static lombok;
    requires java.naming;

    opens lk.ijse.bookworm_lms to javafx.fxml;
    exports lk.ijse.bookworm_lms;
    exports lk.ijse.bookworm_lms.controller;
    opens lk.ijse.bookworm_lms.controller to javafx.fxml;
    opens lk.ijse.bookworm_lms.entity;
    opens lk.ijse.bookworm_lms.dto;
    opens lk.ijse.bookworm_lms.dao;
}