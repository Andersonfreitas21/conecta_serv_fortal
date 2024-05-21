package br.com.conectaservfortal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "tb_roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<Usuario> users;
    @JsonBackReference
    public Set<Usuario> getUsers() {
        return users;
    }
}
