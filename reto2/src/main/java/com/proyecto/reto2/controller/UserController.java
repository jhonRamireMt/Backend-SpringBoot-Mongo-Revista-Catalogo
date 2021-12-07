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
       return userService.createUser(new User(userService.sumarID(),
               user.getIdentification(),user.getName(),
               user.getAddress(),user.getCellPhone(),
               user.getEmail(),user.getPassword(),
               user.getZone(),user.getType()));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/emailexist/{email}")
    @ResponseStatus(HttpStatus.OK)
    public boolean findByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }

    @GetMapping("/{email}/{password}")
    @ResponseStatus(HttpStatus.OK)
    public User finByEmailAndPassword(@PathVariable String email, @PathVariable String password){
        return userService.findByEmailAndPassword(email,password);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
}
