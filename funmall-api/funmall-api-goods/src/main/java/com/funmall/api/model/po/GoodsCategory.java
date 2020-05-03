package com.funmall.api.model.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "d_goods_category")
@Data
public class GoodsCategory {
    private Integer id;

    private String categoryName;

    private Integer parent;

    private Integer level;

    private Integer sort;

    private Date createtm;


}