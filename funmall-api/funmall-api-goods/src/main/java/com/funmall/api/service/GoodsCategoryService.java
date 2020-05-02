package com.funmall.api.service;

import com.funmall.api.model.dto.GoodCategoryDto;
import com.funmall.api.hystrix.GoodsCategoryServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: WilliamDream
 * @Description:
 */

@FeignClient(value = "goods-service",fallback = GoodsCategoryServiceHystrix.class)
public interface GoodsCategoryService {

    GoodCategoryDto getById(@RequestParam("id") Integer id);

    void save(@RequestBody GoodCategoryDto goodCategoryDto);

    void update(@RequestBody GoodCategoryDto goodCategoryDto);

    void delete(@RequestParam("id") Integer id);
}
