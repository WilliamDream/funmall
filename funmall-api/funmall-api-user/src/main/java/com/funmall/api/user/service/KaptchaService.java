package com.funmall.api.user.service;

import com.funmall.api.user.pojo.dto.KaptchaDto;
import com.funmall.api.user.service.hystrix.UserServiceHystrix;
import com.funmall.commons.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: WilliamDream
 * @Description:
 * @Date: 2020/9/1 16:50
 */
@FeignClient(serviceId = "user-service",fallback = UserServiceHystrix.class)
public interface KaptchaService {

    @GetMapping("/user-service/kaptch/getKaptchaCode")
    ResultVo getKaptchaCode();

    @PostMapping("/user-service/kaptch/validateKaptchaCode")
    ResultVo validateKaptchaCode(@RequestBody KaptchaDto kaptchaDto);

}
