package lk.ijse.bookworm_lms.dto;

import lk.ijse.bookworm_lms.entity.Admin;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AdminDTO {
    private int id;
    private String name;
    private String password;

    public AdminDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Admin toEntity(){
        return new Admin(id,name,password);
    }
}
