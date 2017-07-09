package ru.note.service;

import ru.note.exception.IncorrectAuthorizationException;
import ru.note.exception.UnavailableLoginException;

/**
 * Created by Bucky on 09.07.2017.
 */
public interface AuthorizationService {


    Long registerUser(String login, String password) throws IncorrectAuthorizationException;

    Long login(String login, String password) throws IncorrectAuthorizationException;
}
