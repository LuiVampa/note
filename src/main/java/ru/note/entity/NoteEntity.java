package ru.note.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hsqldb.rights.User;

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
    @GeneratedValue(generator = "NOTE_SEQ",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "NOTE_SEQ",
            sequenceName = "NOTE_SEQUENCE",
            allocationSize=1)
    private Long id;

    private String content;

    @OneToOne
    @JoinColumn(name = "userentity_id")
    private UserEntity creator;

    private Long createDate;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "noteinforntity_id")
    private List<NoteInfoEntity> noteInfo;

    public NoteEntity(String content, UserEntity creator, Long createDate) {
        this.content = content;
        this.creator = creator;
        this.createDate = createDate;
    }
}
