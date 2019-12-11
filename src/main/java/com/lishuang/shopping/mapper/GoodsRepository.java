package com.lishuang.shopping.mapper;

import com.lishuang.shopping.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository  extends JpaRepository<Goods,Integer>{

    public List<Goods> findGoodsByGoodsNameLike(String goodsName);


}
