package ru.note.entity;

import javax.persistence.*;

/**
 * Created by Bucky on 08.07.2017.
 */
@Entity
public class NoteInfoEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long changeDate;

    @JoinColumn(name = "USERENTITY_ID")
    private Long changer;
}
