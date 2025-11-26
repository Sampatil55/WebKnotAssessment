package com.college.college.service;

import com.college.college.entity.User;
import com.college.college.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public String addUser(User user) {
        User user1 = new User();
        user1.setId(user.getId());
        user1.setUsername(user.getUsername());
        user1.setMobile(user.getMobile());
        user1.setEmail(user.getEmail());
        userRepository.save(user1);
        return "User created";
    }


    public List<User> getAllUsers() {
        List<User> getAllUsers = userRepository.findAll();
        return getAllUsers;

    }

    public User getUserById(long id) {
        Optional<User> opId = userRepository.findById(id);
        User user = opId.get();
        return user;
    }

    public String deleteUserById(long id) {
        userRepository.deleteById(id);
        return "Record deleted";
    }


    public User updateUserById(long id, User user) {
        Optional<User> updateId = userRepository.findById(id);

        User newUser = new User();
        if (updateId.isPresent()) {
            newUser = updateId.get();
            newUser.setEmail(user.getEmail());
            newUser.setUsername(user.getUsername());
            return userRepository.save(newUser);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }

}
