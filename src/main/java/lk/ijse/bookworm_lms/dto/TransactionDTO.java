package lk.ijse.bookworm_lms.dto;

import lombok.*;

import java.sql.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class TransactionDTO {

    private int id;
    private String userName;
    private String bookTitle;
    private String branch;
    private Timestamp borrowing;
    private Timestamp returning;

}
