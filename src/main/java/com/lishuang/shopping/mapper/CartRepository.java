package com.lishuang.shopping.mapper;


import com.lishuang.shopping.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
//        通过 查询一个 用户下所有的商品 来 组成 购物车
        public List<Cart> findAllItemByUserId(int userId);

}
