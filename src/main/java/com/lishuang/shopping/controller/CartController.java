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

    /**
     *  查看 购物车 功能
     * @param userId
     * @param model
     * @return
     */
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
//        为页面设置总价
        model.addAttribute("sum",sum);
        return allItemByUserId;
    }

    /**
     * 添加购物项到购物车
     * @param userId
     * @param goodsId
     * @param session
     * @return
     */
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
