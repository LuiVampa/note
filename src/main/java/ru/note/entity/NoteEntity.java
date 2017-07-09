package ru.note.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Bucky on 08.07.2017.
 */
@Entity
@Data
@NoArgsConstructor
public class NoteEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String content;

    @OneToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "id")
    private Long creator;

    private Long createDate;

    @OneToMany(targetEntity = NoteInfoEntity.class)
    @JoinColumn(name = "id")
    private List<NoteInfoEntity> noteInfo;


}
