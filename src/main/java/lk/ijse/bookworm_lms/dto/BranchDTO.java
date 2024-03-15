package lk.ijse.bookworm_lms.dto;

import lk.ijse.bookworm_lms.entity.Admin;
import lk.ijse.bookworm_lms.entity.Branch;
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

    public BranchDTO(String name, String manager, String address, String email) {
        this.name = name;
        this.manager = manager;
        this.address = address;
        this.email = email;
    }

    public Branch toEntity(){
        return new Branch(id, name, manager, address, email);
    }
}
