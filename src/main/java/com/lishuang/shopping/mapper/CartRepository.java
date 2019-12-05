package com.lishuang.shopping.mapper;


import com.lishuang.shopping.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
        public List<Cart> findAllItemByUserId(int userId);
}
