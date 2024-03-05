package lk.ijse.bookworm_lms.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "Branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "manager")
    private String manager;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    public Branch(String name, String manager, String address, String email) {
        this.name = name;
        this.manager = manager;
        this.address = address;
        this.email = email;
    }
}
