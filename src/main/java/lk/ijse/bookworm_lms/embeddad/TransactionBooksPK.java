package lk.ijse.bookworm_lms.embeddad;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Embeddable
public class TransactionBooksPK implements Serializable {
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "transaction_id")
    private int transactionId;
}
