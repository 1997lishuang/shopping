package com.lishuang.shopping.mapper;

import com.lishuang.shopping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepositoty extends JpaRepository<User,Integer> {

}
