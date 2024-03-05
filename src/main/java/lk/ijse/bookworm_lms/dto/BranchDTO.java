package lk.ijse.bookworm_lms.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class BranchDTO {
    private int id;
    private String name;
    private String manager;
    private String address;
    private String email;
}
