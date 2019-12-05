package com.lishuang.shopping.mapper;

import com.lishuang.shopping.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository  extends JpaRepository<Goods,Integer> {
}
