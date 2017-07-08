package ru.note.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.note.entity.UserEntity;

/**
 * Created by Bucky on 08.07.2017.
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
