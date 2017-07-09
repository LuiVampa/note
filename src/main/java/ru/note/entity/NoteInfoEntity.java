package ru.note.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Bucky on 08.07.2017.
 */
@Entity
@Data
@NoArgsConstructor
public class NoteInfoEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long changeDate;

    @OneToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "id")
    private Long changer;
}
