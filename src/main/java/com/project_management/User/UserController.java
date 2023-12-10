package com.project_management.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;


    // GetMapping - means get requires + url
    @GetMapping("/{id}")
    public User getUser(Long id) 
    {
        // search user and return it
        return userRepository.findById(id).get();
    }


    @GetMapping("/all")
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user)
    {
        BCryptPasswordEncoder bcp = new BCryptPasswordEncoder();
        String decodedPassoword = bcp.encode(user.getPassword());
        user.setPassword(decodedPassoword);

        userRepository.save(user);


        return user;
    }


    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id)
    {
        User existingUser = userRepository.findById(id).get();
        // need update:
        // if updating email -> verify email through mail
        // if updating password -> same + encryption
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());

        if (existingUser.getEmail() != user.getEmail())
        {
            // handle email verification
        }

        userRepository.save(existingUser);

        return existingUser;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id)
    {
        try {
            userRepository.deleteById(id);
            return "Successfully deleted user";
        } catch (Exception e) {
            return "User not found";
        }
    }
}
