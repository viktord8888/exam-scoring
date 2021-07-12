package org.viktord8888.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.viktord8888.user.User;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersRepositoryAdapter implements UsersRepository {

    private final UsersJPARepository usersJPARepository;

    @Override
    public User save(User user) {
        return usersJPARepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return usersJPARepository.findById(id);
    }

    @Override
    public List<User> findByEmail(String email) {
        return usersJPARepository.findAllByEmail(email);
    }

    @Override
    public List<User> findByUserName(String username) {
        return usersJPARepository.findByUserName(username);
    }

    @Override
    public List<User> listUsers() {
        return usersJPARepository.findAll();
    }
}
