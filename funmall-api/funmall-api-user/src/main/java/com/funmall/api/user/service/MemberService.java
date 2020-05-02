package com.funmall.api.user.service;

import com.funmall.api.user.pojo.dto.UserDto;
import com.funmall.api.user.service.hystrix.MemberServiceHystrix;
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
 * @Date: 2020/1/18 17:03
 */

@FeignClient(serviceId = "user-service",fallback = MemberServiceHystrix.class)
public interface MemberService {

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
    @PostMapping("/user-service/member/userLogin")
    ResultVo userLogin(@RequestBody UserDto userDto);

    @GetMapping("/user-service/member/userLoginout")
    ResultVo userLoginout(@RequestParam Long id);

    @GetMapping("/user-service/member/queryMemberById")
    ResultVo queryMemberById(@RequestParam Long id);

    @PostMapping("/user-service/member/updateMemberById")
    ResultVo updateMemberById(@RequestBody UserDto userDto);

    @PostMapping("/user-service/member/updateHeadImage")
    ResultVo updateHeadImage(@RequestBody UserDto userDto);

    @GetMapping("/user-service/member/delMember")
    ResultVo delMember(@RequestParam Long id);

}
