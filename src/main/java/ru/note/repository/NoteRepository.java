package ru.note.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.note.entity.NoteEntity;

/**
 * Created by Bucky on 08.07.2017.
 */
public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
}
