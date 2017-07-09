package ru.note.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Bucky on 08.07.2017.
 */
@Entity
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(generator = "USER_SEQ",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "USER_SEQ",
            sequenceName = "USER_SEQUENCE",
            allocationSize=1)
    private Long id;

    @Column(unique = true)
    private String login;

    private String password;

    public UserEntity(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
