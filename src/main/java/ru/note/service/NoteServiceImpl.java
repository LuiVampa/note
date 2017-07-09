package ru.note.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.note.entity.NoteEntity;
import ru.note.entity.NoteInfoEntity;
import ru.note.entity.UserEntity;
import ru.note.DTO.NoteDTO;
import ru.note.repository.NoteRepository;
import ru.note.repository.UserRepository;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Bucky on 10.07.2017.
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addNote(Long id, String note) {
        noteRepository.save(new NoteEntity(note,
                userRepository.findOne(id),
                Instant.now().getEpochSecond()));
    }

    @Override
    public List<NoteDTO> loadNotes(Integer page) {
        PageRequest request = new PageRequest(
                page - 1,
                10,
                Sort.Direction.DESC,
                "createDate");
        return createNotes(noteRepository.findAll(request).getContent(), userRepository.findAll());
    }

    @Override
    public Long pageCount() {
        long count = noteRepository.count();
        return count == 0 ? 1 : (long)Math.ceil((double) count / 10) ;
    }

    private List<NoteDTO> createNotes(List<NoteEntity> notes, List<UserEntity> users) {

        List<NoteDTO> allNotes = new ArrayList<>();

        for (NoteEntity note : notes) {
            allNotes.add(NoteDTO.builder()
                    .id(note.getId())
                    .content(note.getContent())
                    .name(users.stream()
                            .filter(user -> note.getCreator().getId().equals(user.getId()))
                            .findFirst()
                            .map(UserEntity::getLogin)
                            .orElseThrow(NullPointerException::new))
                    .date(LocalDateTime.ofInstant(
                            Instant.ofEpochMilli(note.getCreateDate()), ZoneId.systemDefault())
                            .format(DateTimeFormatter.ofPattern("HH:mm MM-dd-YYYY"))).build());
        }
        return allNotes;
    }

    @Override
    public void removeNote(Long noteId) {
        noteRepository.delete(noteId);
    }

    @Override
    @Transactional
    public void editNote(Long id, Long noteId, String content) {
        UserEntity changer = userRepository.findOne(id);
        NoteEntity note = noteRepository.findOne(noteId);
        note.setContent(content);
        List<NoteInfoEntity> noteInfoList = new ArrayList<>();
        noteInfoList.add(new NoteInfoEntity(Instant.now().getEpochSecond(), changer));
        note.setNoteInfo(noteInfoList);
        noteRepository.save(note);
    }
}
