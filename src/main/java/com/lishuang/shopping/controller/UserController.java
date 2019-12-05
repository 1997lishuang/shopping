package com.lishuang.shopping.controller;

import com.lishuang.shopping.entity.User;
import com.lishuang.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/login")
    @ResponseBody
    public List<User> login(){
        List<User> allUser = userService.findAllUser();
        return allUser;
    }
}
