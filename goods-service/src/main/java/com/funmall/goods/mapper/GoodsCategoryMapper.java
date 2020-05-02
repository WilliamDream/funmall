package com.funmall.goods.mapper;


import com.funmall.goods.pojo.po.GoodsCategory;

import java.util.List;

public interface GoodsCategoryMapper {
    int insert(GoodsCategory record);

    List<GoodsCategory> selectAll();
}