package com.funmall.user.web;

import com.funmall.api.user.pojo.dto.UserDto;
import com.funmall.api.user.service.MemberService;
import com.funmall.commons.vo.ResultVo;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: WilliamDream
 * @Description:
 * @Date: 2019/9/1 17:35
 */

@RestController
public class MemberController implements MemberService{


    @Override
    public ResultVo userRegister(UserDto userDto) {
        return null;
    }

    @Override
    public ResultVo userLogin(UserDto userDto) {
        return null;
    }

    @Override
    public ResultVo userLoginout(Long id) {
        return null;
    }

    @Override
    public ResultVo queryMemberById(Long id) {
        return null;
    }

    @Override
    public ResultVo updateMemberById(UserDto userDto) {
        return null;
    }

    @Override
    public ResultVo updateHeadImage(UserDto userDto) {
        return null;
    }

    @Override
    public ResultVo delMember(Long id) {
        return null;
    }
}
