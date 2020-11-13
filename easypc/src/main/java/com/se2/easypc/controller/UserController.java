package com.se2.easypc.controller;

import com.se2.easypc.data_access.model.User;
import com.se2.easypc.pojo.NewPasswordPOJO;
import com.se2.easypc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//permit cross origin requests
@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

    private static final Logger logger = LogManager.getLogger();

    //declares corresponding service
    @Autowired
    UserService userService;

    //get http request for all users
    @GetMapping("/users")
    public List<User> getAllUsers( HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return userService.getAllUsers();
    }

    //get http request for user by specific ID
    @GetMapping("/user/{id}")
    public User getUsersById(@PathVariable(value = "id") Long userId, HttpServletRequest request ) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return userService.getUserById(userId);
    }

    //Post http request for user
    @PostMapping("/user")
    //request body with object to post
    public User createUser(@Valid @RequestBody User user, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //return the corresponding service logical function
        return userService.createUser(user);
    }

    //Delete http request for user by ID
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Long userId, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        //call the corresponding service logical function
        userService.deleteUser(userId);
        //Check deletion
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user/change-password")
    //request body with object to post
    public User changePassword(@Valid @RequestBody NewPasswordPOJO newPass, HttpServletRequest request) {
        //append to log
        logger.trace( request.getRemoteAddr() );
        System.out.println("NUEVA CONTRASEÑA:" + newPass.getNewPassword());
        String username = SecurityContextHolder.getContext( ).getAuthentication( ).getName( );
        User user = userService.findByUsername( username );
        //return the corresponding service logical function
        return userService.changePassword(user,newPass.getNewPassword());
    }

}
