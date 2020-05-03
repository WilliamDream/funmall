package com.funmall.api.service;

import com.funmall.api.model.dto.GoodCategoryDto;
import com.funmall.api.hystrix.GoodsCategoryServiceHystrix;
import com.funmall.api.model.vo.GoodCategoryVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: WilliamDream
 * @Description:
 */

@FeignClient(value = "goods-service",fallback = GoodsCategoryServiceHystrix.class)
public interface GoodsCategoryService {

    GoodCategoryDto getById(@RequestParam("id") Integer id);

    List<GoodCategoryVo> getList(@RequestBody GoodCategoryDto goodCategoryDto);

    void save(@RequestBody GoodCategoryDto goodCategoryDto);

    void update(@RequestBody GoodCategoryDto goodCategoryDto);

    void delete(@RequestParam("id") Integer id);
}
