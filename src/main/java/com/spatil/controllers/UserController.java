package com.spatil.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spatil.beans.User;
import com.spatil.service.UserService;

@RestController
@RequestMapping("/rest/user")
public class UserController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String test() {
        log.info("Test");
        return "OK";
    }

    @RequestMapping("/get")  
    public User getUser(@RequestParam("id") long id) {
        log.info("Get user");
        return userService.getUserById(id);
    }
  
    @RequestMapping("/save")
    public void saveUser(@RequestParam("name")String name, @RequestParam("email")String email) {
    	User user = new User(name, email);
    	log.info("Save User");
    	userService.saveUser(user);
    }
} 
