package lk.ijse.bookworm_lms.embeddad;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Embeddable
public class UserBooksPK implements Serializable {
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "transaction_id")
    private int transactionId;
}
