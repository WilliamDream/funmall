package com.funmall.api.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author: WilliamDream
 * @Description:
 */
@Data
public class GoodCategoryVo {

    private Integer id;

    private String categoryName;

    private Integer parent;

    private Integer level;

    private Integer sort;

    private Date createtm;



}
