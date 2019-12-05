package com.lishuang.shopping.controller;

import com.lishuang.shopping.entity.Cart;

import com.lishuang.shopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;
    @RequestMapping("/findAllItemByUserId")
    @ResponseBody
    public List<Cart> findAllItemByUserId(int userId){
        List<Cart> allItemByUserId =cartService.findAllItemByUserId(userId);
        return allItemByUserId;
    }
    @RequestMapping("/addItemToCart")
    @ResponseBody
    public int addItemToCart(Cart cart){
        int status = cartService.addItemToCartSevice(cart);
        if (status==405){
            return  405;
        }
        return 200;
    }
}
