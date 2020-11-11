package com.controllers;

import com.entities.User;
import com.repositories.UserDao;
import com.usils.WsAddressConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(WsAddressConstants.userLogicUrl)
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping(value = "createUser")
    public User createUser(@RequestBody User user) {
        return userDao.save(user);
    }

    @GetMapping(value = "getByAccount/{accountId}")
    public List<User> createUser(@PathVariable Long accountId) {
        return userDao.getByAccountId(accountId);
    }

}
