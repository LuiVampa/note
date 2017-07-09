package ru.note.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.note.entity.NoteEntity;

import java.util.List;

/**
 * Created by Bucky on 08.07.2017.
 */
@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
}
