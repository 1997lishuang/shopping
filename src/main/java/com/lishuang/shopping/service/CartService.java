package com.lishuang.shopping.service;

import com.lishuang.shopping.entity.Cart;
import com.lishuang.shopping.mapper.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    public List<Cart> findAllItemByUserId(int userId){

        List<Cart> allItemByUserId = cartRepository.findAllItemByUserId(userId);
        return allItemByUserId;
    }

    public int addItemToCartSevice(Cart cart){

        Cart save = cartRepository.save(cart);
        if (save==null){
            return 404;
        }
        return 200;
    }
}
