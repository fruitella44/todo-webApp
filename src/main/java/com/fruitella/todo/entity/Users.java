package com.fruitella.todo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, length = 50, nullable = false)
    private String username;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "email", length = 75, nullable = false)
    private String email;

    @OneToMany(mappedBy = "users")
    private List<Todo> todos;

}
