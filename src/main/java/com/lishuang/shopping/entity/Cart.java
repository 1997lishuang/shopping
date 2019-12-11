package com.lishuang.shopping.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue
    public int cartId;
    public String goodsName;
    public int goodsSinglePrice;
    public int goodsNum;
    public int goodsTotalPrice;
    public int userId;
    public int goodsId;
    public String goodsImage;
//    一个购物车 拥有 一个 商品 的 单向 关系
    @OneToOne(targetEntity = Goods.class )
    @JoinColumn(name = "goodsId", referencedColumnName = "goodsId",insertable=false, updatable=false)
    public Goods goods;

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public int getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(int goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsSinglePrice() {
        return goodsSinglePrice;
    }

    public void setGoodsSinglePrice(int goodsSinglePrice) {
        this.goodsSinglePrice = goodsSinglePrice;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }
}
