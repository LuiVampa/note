package ru.note.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.note.entity.UserEntity;
import ru.note.exception.IncorrectAuthorizationException;
import ru.note.exception.UnavailableLoginException;
import ru.note.repository.UserRepository;

import javax.persistence.NonUniqueResultException;
import java.util.Objects;

/**
 * Created by Bucky on 08.07.2017.
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Long registerUser(String login, String password) throws IncorrectAuthorizationException {
        if (userRepository.findByLogin(login) != null) {
            throw new IncorrectAuthorizationException();
        }
        return userRepository.save(new UserEntity(login, password)).getId();
    }

    @Override
    public Long login(String login, String password) throws IncorrectAuthorizationException {
        return checkUser(login, password);
    }

    private Long checkUser(String login, String password) throws IncorrectAuthorizationException {
        UserEntity foundUser = userRepository.findByLogin(login);
        if (foundUser == null || !Objects.equals(password, foundUser.getPassword())){
            throw new IncorrectAuthorizationException();
        }
        return foundUser.getId();
    }
}
