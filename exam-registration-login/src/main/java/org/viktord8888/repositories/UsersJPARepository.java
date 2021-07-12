package org.viktord8888.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.viktord8888.user.User;

import java.util.List;

@Repository
public interface UsersJPARepository extends JpaRepository<User, Long> {

    List<User> findAllByEmail(String email);

    List<User> findByUserName(String username);
}
