package lk.ijse.bookworm_lms.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "branch")
    private String branch;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "genre")
    private String genre;

    @Column(name = "status")
    private String status;

    @Column(name = "dateTime")
    @CreationTimestamp
    private Timestamp dateTime;

    @ManyToMany(mappedBy = "bookList")
    private List<Branch> branchList = new ArrayList<>();

}
