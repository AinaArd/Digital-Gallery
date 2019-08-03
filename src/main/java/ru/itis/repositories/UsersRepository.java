package ru.itis.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.transfer.UserDto;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    @Query(nativeQuery = true, value = "select * from \"user\" inner join gallery g on " +
            "\"user\".id = g.owner_id where g.owner_id = ?")
    Optional<User> checkIfOwner(Long id);

    List<UserDto> findByNameContaining(String name);

    Optional<User> findByName(String name);
}
