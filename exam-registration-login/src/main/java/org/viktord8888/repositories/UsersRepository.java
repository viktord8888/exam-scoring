package org.viktord8888.repositories;

import org.viktord8888.user.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository {

    User save(User user);

    Optional<User> findById(Long id);

    List<User> findByEmail(String email);

    List<User> findByUserName(String username);

    List<User> listUsers();
}
