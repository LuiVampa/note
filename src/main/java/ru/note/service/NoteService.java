package ru.note.service;

import ru.note.DTO.NoteDTO;

import java.util.List;

/**
 * Created by Bucky on 10.07.2017.
 */
public interface NoteService {

    void addNote(Long id, String note);

    List<NoteDTO> loadNotes(Integer page);

    Long pageCount();

    void removeNote(Long noteId);

    void editNote(Long id, Long noteId, String content);
}
