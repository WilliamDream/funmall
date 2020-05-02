package com.funmall.api.user.service;

import com.funmall.api.user.pojo.dto.UserDto;
import com.funmall.api.user.service.hystrix.UserServiceHystrix;
import com.funmall.commons.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: WilliamDream
 * @Description:
 * @Date: 2019/9/1 14:42
 */
@FeignClient(serviceId = "user-service",fallback = UserServiceHystrix.class)
public interface UserService {

    /**
       * @Description
       * @param userDto
       * @return com.funmall.commons.vo.ResultVo
       */
    @PostMapping("/user-service/user/userRegister")
    ResultVo userRegister(@RequestBody UserDto userDto);

    /**
       * @Description
       * @param userDto
       * @return com.funmall.commons.vo.ResultVo
       */
    @PostMapping("/user-service/user/userLogin")
    ResultVo userLogin(@RequestBody UserDto userDto);

    @GetMapping("/user-service/user/delUser")
    ResultVo delUser(@RequestParam Long id);

}
