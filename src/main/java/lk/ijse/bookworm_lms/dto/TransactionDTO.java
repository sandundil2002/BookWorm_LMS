package lk.ijse.bookworm_lms.dto;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class TransactionDTO {

    private int id;
    private int userId;
    private String bookTitle;
    private String branch;
    private Timestamp borrowing;
    private Timestamp returning;

}
