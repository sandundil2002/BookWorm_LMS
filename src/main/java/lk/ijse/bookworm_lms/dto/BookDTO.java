package lk.ijse.bookworm_lms.dto;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class BookDTO {
    private int id;
    private String branch;
    private String title;
    private String author;
    private String genre;
    private String status;
    private Timestamp dateTime;
}
