package lk.ijse.bookworm_lms.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    private String branch;

    private String title;

    private String author;

    private String genre;

    private String status;

    @CreationTimestamp
    private Timestamp dateTime;

    @OneToMany(mappedBy = "book")
    private List<BookTransactionDetails> userBooks = new ArrayList<>();

    public Book(String branch, String author, String title, String genre, String status) {
        this.branch = branch;
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.status = status;
    }

}
