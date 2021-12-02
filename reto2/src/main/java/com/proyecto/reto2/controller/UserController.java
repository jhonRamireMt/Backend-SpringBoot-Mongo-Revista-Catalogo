package com.proyecto.reto2.controller;

import com.proyecto.reto2.model.User;
import com.proyecto.reto2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
       return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/emailexist/{email}")
    @ResponseStatus(HttpStatus.FOUND)
    public boolean findByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }

    @GetMapping("/{email}/{password}")
    //@ResponseStatus(HttpStatus.FOUND)
    public User finByEmailAndPassword(@PathVariable String email, @PathVariable String password){
        return userService.findByEmailAndPassword(email,password);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
}
