package lk.ijse.bookworm_lms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

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

    @Column(name = "book_title")
    private String bookTitle;

    private String branch;

    private Timestamp borrowing;

    private Timestamp returning;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
