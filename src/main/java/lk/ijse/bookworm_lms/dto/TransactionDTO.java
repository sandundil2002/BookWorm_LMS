package lk.ijse.bookworm_lms.dto;

import lombok.*;

import java.sql.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class TransactionDTO {

    private int id;
    private String branch;
    private String bookTitle;
    private String userName;
    private Date borrowing;
    private Date returning;

}
