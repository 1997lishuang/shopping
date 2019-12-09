package com.lishuang.shopping.service;

import com.lishuang.shopping.entity.Cart;
import com.lishuang.shopping.mapper.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    public List<Cart> findAllItemByUserId(int userId){

        List<Cart> allItemByUserId = cartRepository.findAllItemByUserId(userId);
        return allItemByUserId;
    }

    public int addItemToCartSevice(int userId, int goodsId, HttpSession session){
        Cart cart = cartRepository.getOne(goodsId);
        //用map做购物车
        Map<Cart,Integer> carts = new HashMap<>();
        Cart shopcart = (Cart) session.getAttribute("cart");
        if (shopcart==null){
            session.setAttribute("cart",cart);
        }
        for (Cart cartItem : carts.keySet()){
//              如果map中 存在 商品 就 加 数量
             if(cartItem.getGoodsId()==cart.getGoodsId()){
                 Integer number = carts.get(cartItem);
                 cartItem.setGoodsNum(number+cart.getGoodsNum());
             }
//           如果没有存在购物车中就添加到购物车
             carts.put(cart,cart.getGoodsNum());
        }

        Cart save = cartRepository.save(cart);
        if (save==null){
//            根据用户id查找购物车 的 商品 SELECT * FROM cart WHERE user_id = 用户名； 查询到 用户所有 购买的商品 返回 为lsit 集合
            return 404;
        }
        return 200;
    }
}
