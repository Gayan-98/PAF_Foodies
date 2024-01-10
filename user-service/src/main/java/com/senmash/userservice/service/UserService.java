package com.senmash.userservice.service;


import com.senmash.userservice.model.User;
import com.senmash.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    //crate new user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    //view user
    public Optional<User> getUserById(int userId) {
        return userRepository.findById(userId);
    }


    //delete user
    public ResponseEntity<?> deleteUserById(int id){

        try {
            Optional<User> user = userRepository.findById(id);

            if (user.isPresent()) {

                userRepository.deleteById(id);
                return new ResponseEntity<>("successfully deleted ", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No Student Found", HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>("An error occurred while deleting the status.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


   //update user profile
    public ResponseEntity<?>updateUser(User user){
        userRepository.save(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }





}
