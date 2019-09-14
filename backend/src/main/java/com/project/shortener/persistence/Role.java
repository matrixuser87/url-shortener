/*
 * Developed by Bobi and Tzvetan <bzn@abv.bg>
 * Last modified 7/28/19 5:53 PM.
 * Copyright (c) 2019.
 */

package com.project.shortener.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Roles.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Role {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "description")
    private String description;
}
