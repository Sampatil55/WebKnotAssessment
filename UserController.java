package com.college.college.controller;

import com.college.college.entity.User;
import com.college.college.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    //http://localhost:8080/api/v1/create
    @PostMapping("/create")
    public ResponseEntity<?> createUser(
            @RequestBody User user
    ) {
        String addUser = userService.addUser(user);
        return new ResponseEntity<>(addUser, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/v1/getAllUser
    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAlluser(
    ) {
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/findBy/1
    @GetMapping("/findBy/{id}")
    public ResponseEntity<?> getById(
            @PathVariable long id
    ) {
        User getUser = userService.getUserById(id);
        return new ResponseEntity<>(getUser, HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/updateById/1
    @PutMapping("/updateById/{id}")
    public ResponseEntity<?> updateUser(
            @PathVariable long id,
            @RequestBody User user
    ) {
        User updatedUser = userService.updateUserById(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/delete/1
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeUser(
            @PathVariable long id
    ) {

        String deleteUser = userService.deleteUserById(id);
        return new ResponseEntity<>(deleteUser, HttpStatus.OK);


    }
}
