package ru.note.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.note.entity.UserEntity;

/**
 * Created by Bucky on 08.07.2017.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByLogin(String login);
}
