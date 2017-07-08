package ru.note.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Bucky on 08.07.2017.
 */
@Entity
public class NoteEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String content;

    @OneToOne
    @JoinColumn(name = "USERENTITY_ID")
    private Long creator;

    private Long createDate;

    @OneToMany
    @JoinColumn(name = "NOTEINFOENTITY_ID")
    private List<NoteInfoEntity> noteInfo;
}
