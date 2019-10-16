package com.example.demo.controller;

import com.example.demo.entity.JsonResult;
import com.example.demo.pojo.User;
import com.example.demo.service.TokenService;
import com.example.demo.service.UserService;
import com.example.demo.vo.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @RequestMapping("/login")
    public JsonResult getUserByName(login login) throws Exception{
        return userService.findUserByName(login);
    }
}
