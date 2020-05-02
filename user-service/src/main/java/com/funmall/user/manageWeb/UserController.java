package com.funmall.user.manageWeb;

import com.funmall.api.user.pojo.dto.UserDto;
import com.funmall.api.user.service.UserService;
import com.funmall.commons.vo.ResultVo;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: WilliamDream
 * @Description:
 * @Date: 2019/9/1 17:41
 */

@RestController
public class UserController implements UserService{

    @Override
    public ResultVo userRegister(UserDto userDto) {
        return null;
    }

    @Override
    public ResultVo userLogin(UserDto userDto) {
        return null;
    }

    @Override
    public ResultVo delUser(Long id) {
        return null;
    }
}
