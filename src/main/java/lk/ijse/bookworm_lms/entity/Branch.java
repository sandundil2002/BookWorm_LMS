package lk.ijse.bookworm_lms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Data

@Entity
@Table(name = "Branch")
public class Branch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private int id;

    private String name;

    private String manager;

    private String address;

    private String email;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public Branch(String name, String manager, String address, String email) {
        this.name = name;
        this.manager = manager;
        this.address = address;
        this.email = email;
    }

}
