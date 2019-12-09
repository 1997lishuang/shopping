package com.lishuang.shopping.controller;

import com.lishuang.shopping.entity.Cart;

import com.lishuang.shopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;
    @RequestMapping("/findAllItemByUserId")
    @ResponseBody
    public List<Cart> findAllItemByUserId(int userId, Model model){
        List<Cart> allItemByUserId =cartService.findAllItemByUserId(userId);
        int sum = 0;
        int singlesum= 0;
        for (Cart cart: allItemByUserId){
                  singlesum = cart.getGoodsNum() * cart.getGoodsSinglePrice();
                  cart.setGoodsTotalPrice(singlesum);
                  sum += cart.getGoodsTotalPrice();
        }
        model.addAttribute("allItemByUserId",allItemByUserId);
        return allItemByUserId;
    }
    @RequestMapping("/addItemToCart")
    @ResponseBody
    public int addItemToCart(int userId, int goodsId,HttpSession session){
        int status = cartService.addItemToCartSevice(userId,goodsId,session);
        if (status==404){
            return  404;
        }
        return 200;
    }
}
