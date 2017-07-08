package ru.note.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Bucky on 08.07.2017.
 */
@Entity
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String login;

    private String password;
}
