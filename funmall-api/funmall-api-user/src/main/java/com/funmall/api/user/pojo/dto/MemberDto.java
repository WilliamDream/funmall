package com.funmall.api.user.pojo.dto;

import java.util.Date;

/**
 * @Author: WilliamDream
 * @Description:
 * @Date: 2020/1/18 17:06
 */
public class MemberDto {

    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码 md5加密存储
     */
    private String password;

    /**
     * 注册手机号
     */
    private String phone;

    /**
     * 注册邮箱
     */
    private String email;

    private String sex;

    private String address;

    private Integer state;

    private String description;

    private Integer roleId;

    /**
     * 头像
     */
    private String file;

    private Date created;

    private Date updated;

}
