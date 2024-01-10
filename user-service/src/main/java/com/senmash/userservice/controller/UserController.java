package com.senmash.userservice.controller;


import com.senmash.userservice.model.User;
import com.senmash.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {


    private UserService userService;
    @PostMapping("/save")
    private User saveUser(@RequestBody User user ){

        return  userService.saveUser(user);
    }

    @GetMapping("/get/{userId}")
    private Optional <User> getUserById(@PathVariable("userId") int  uerId){
        return userService.getUserById(uerId);
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") int id){
        return userService.deleteUserById(id);
    }



    @PutMapping("/update")
    public ResponseEntity<?>updateUserById(@RequestBody User user){
        return userService.updateUser(user);

    }


}
