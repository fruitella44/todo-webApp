package com.fruitella.todo.bean;

import com.fruitella.todo.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorisationBean implements Serializable {

    private String username;
    private String password;


}
