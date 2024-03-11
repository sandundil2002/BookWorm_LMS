package lk.ijse.bookworm_lms.embeddad;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Embeddable
public class UserBooksPK implements Serializable {
    private String transaction_id;
    private String book_id;
}
