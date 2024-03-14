package lk.ijse.bookworm_lms.embeddad;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class BookTransactionPK implements Serializable {
    private int bookId;
    private int transactionId;
}
