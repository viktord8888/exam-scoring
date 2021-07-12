package org.viktord8888.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.viktord8888.repositories.UsersRepositoryAdapter;
import org.viktord8888.user.User;
import org.viktord8888.user.UserLogin;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AddUserEndpoint {

    private final UsersRepositoryAdapter usersRepositoryAdapter;

    @PostMapping("/register")
    String saveUser(@RequestBody User user) {
        List<User> usersWithEmail = usersRepositoryAdapter.findByEmail(user.getEmail());

        if (!usersWithEmail.isEmpty()) {
            throw new UserRegistrationValidationFailureException();
        }

        usersRepositoryAdapter.save(user);

        return "User account created.";
    }

    @GetMapping("/users")
    List<User> listUsers() {
        return usersRepositoryAdapter.listUsers();
    }

    @PostMapping("/login")
    String findUser(@RequestBody UserLogin userLogin) {
        List<User> existingUser = usersRepositoryAdapter.findByUserName(userLogin.getUserName());

        if (existingUser.isEmpty()) {
            throw new UserLoginFailureException();
        }

        return "Logged in.";
    }
}
