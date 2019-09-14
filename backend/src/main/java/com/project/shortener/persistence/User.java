package com.project.shortener.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * User entity.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UserRole", joinColumns
            = @JoinColumn(name = "userId",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roleId",
                    referencedColumnName = "id"))
    private List<Role> roles;
}
