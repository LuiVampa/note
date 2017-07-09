package ru.note.service;

import ru.note.entity.UserEntity;
import ru.note.exception.IncorrectPasswordException;
import ru.note.noteDTO.NoteDTO;

import java.util.List;

/**
 * Created by Bucky on 09.07.2017.
 */
public interface NoteService {


    void registerUser(String login, String password);


    List<NoteDTO> login(String login, String password) throws IncorrectPasswordException;
}
