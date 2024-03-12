package lk.ijse.bookworm_lms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int id;

    private String userName;

    @Column(name = "book_title")
    private String bookTitle;

    private String branch;

    private Timestamp borrowing;

    private Timestamp returning;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Transaction(String userName, String bookTitle, String branch, Timestamp borrowing, Timestamp returning) {
        this.userName = userName;
        this.bookTitle = bookTitle;
        this.branch = branch;
        this.borrowing = borrowing;
        this.returning = returning;
    }
}
