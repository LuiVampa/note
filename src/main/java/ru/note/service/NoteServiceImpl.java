package ru.note.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.note.entity.NoteEntity;
import ru.note.entity.UserEntity;
import ru.note.exception.IncorrectPasswordException;
import ru.note.noteDTO.NoteDTO;
import ru.note.repository.NoteRepository;
import ru.note.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Bucky on 08.07.2017.
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public void registerUser(String login, String password) {
        userRepository.save(new UserEntity(login, password));
    }

    @Override
    public List<NoteDTO> login(String login, String password) throws IncorrectPasswordException {
        checkUser(new UserEntity(login, password));
        return createNotes(noteRepository.findAll(), userRepository.findAll());
    }

    private void checkUser(UserEntity user) throws IncorrectPasswordException {
        UserEntity foundUser = userRepository.findByLogin(user.getLogin());
        if (!Objects.equals(user.getPassword(), foundUser.getPassword())){
            throw new IncorrectPasswordException();
        }
    }

    private List<NoteDTO> createNotes(List<NoteEntity> notes, List<UserEntity> users) {

        List<NoteDTO> allNotes = new ArrayList<>();

        for (NoteEntity note : notes) {
            allNotes.add(NoteDTO.builder()
                    .content(note.getContent())
                    .name(users.stream()
                            .filter(user -> note.getCreator().equals(user.getId()))
                            .findFirst()
                            .map(UserEntity::getLogin)
                            .orElseThrow(NullPointerException::new))
                    .date(note.getCreateDate())
                    .build());
        }
        return allNotes;
    }
}
