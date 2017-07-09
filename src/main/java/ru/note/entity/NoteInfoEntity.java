package ru.note.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hsqldb.rights.User;

import javax.persistence.*;

/**
 * Created by Bucky on 08.07.2017.
 */
@Entity
@Data
@NoArgsConstructor
public class NoteInfoEntity {

    @Id
    @GeneratedValue(generator = "NOTE_INFO_SEQ",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "NOTE_INFO_SEQ",
            sequenceName = "NOTE_INFO_SEQUENCE",
            allocationSize=1)
    private Long id;

    private Long changeDate;

    @OneToOne()
    @JoinColumn(name = "userentity_id")
    private UserEntity changer;

    public NoteInfoEntity(Long changeDate, UserEntity changer) {
        this.changeDate = changeDate;
        this.changer = changer;
    }
}
