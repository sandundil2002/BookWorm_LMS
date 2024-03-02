package lk.ijse.bookworm_lms.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserDTO {
    private int id;
    private String name;
    private String email;
    private String password;
}
