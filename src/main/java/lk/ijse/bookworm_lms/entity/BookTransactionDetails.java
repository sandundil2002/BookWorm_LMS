package lk.ijse.bookworm_lms.entity;

import jakarta.persistence.*;
import lk.ijse.bookworm_lms.embeddad.TransactionBooksPK;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "book_transaction_details")
public class BookTransactionDetails {

    @EmbeddedId
    private TransactionBooksPK transactionBooksPK;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id",insertable = false,updatable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "transaction_id", referencedColumnName = "transaction_id",insertable = false,updatable = false)
    private Transaction transaction;

    private String status;

}
