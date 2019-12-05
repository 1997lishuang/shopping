package com.lishuang.shopping.service;

import com.lishuang.shopping.entity.User;
import com.lishuang.shopping.mapper.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
   @Autowired
    UserRepositoty userRepositoty;

   public List<User> findAllUser(){

       List<User> allUser = userRepositoty.findAll();
       return allUser;
   }

}
