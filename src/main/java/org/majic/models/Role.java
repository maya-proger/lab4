package org.majic.models;

import jakarta.persistence.*;


@Entity
@Table(name="Roles")
public class Role {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "roles_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }
}

