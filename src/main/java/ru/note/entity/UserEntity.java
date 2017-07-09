package ru.note.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

/**
 * Created by Bucky on 08.07.2017.
 */
@Entity
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;


    private String login;

    private String password;

    public UserEntity(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
