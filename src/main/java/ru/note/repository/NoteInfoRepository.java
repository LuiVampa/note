package ru.note.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.note.entity.NoteInfoEntity;

/**
 * Created by Bucky on 08.07.2017.
 */
@Repository
public interface NoteInfoRepository extends PagingAndSortingRepository<NoteInfoEntity, Long> {
}
