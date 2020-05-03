package com.funmall.goods.mapper;


import com.funmall.goods.model.po.GoodsCategory;

import java.util.List;

public interface GoodsCategoryMapper {
    int insert(GoodsCategory record);

    List<GoodsCategory> selectAll();
}