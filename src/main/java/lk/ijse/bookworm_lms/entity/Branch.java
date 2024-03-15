package lk.ijse.bookworm_lms.entity;

import jakarta.persistence.*;
import lk.ijse.bookworm_lms.dto.BranchDTO;
import lombok.*;

import java.io.Serializable;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "branch")
    private List<Book> books = new ArrayList<>();

    public Branch(String name, String manager, String address, String email) {
        this.name = name;
        this.manager = manager;
        this.address = address;
        this.email = email;
    }

    public BranchDTO toDto(){
        return new BranchDTO(name,manager,address,email);
    }
    
    public Branch(int id, String name, String manager, String address, String email) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.address = address;
        this.email = email;
    }

}
