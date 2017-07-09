package ru.note.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.note.entity.NoteEntity;

/**
 * Created by Bucky on 08.07.2017.
 */
@Repository
public interface NoteRepository extends PagingAndSortingRepository<NoteEntity, Long> {
}
