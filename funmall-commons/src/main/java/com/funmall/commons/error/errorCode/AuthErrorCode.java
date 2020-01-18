package com.funmall.commons.error.errorCode;

import com.funmall.commons.error.errorCode.basic.IErrorCodeEnum;

public enum AuthErrorCode
  implements IErrorCodeEnum
{
  USER_NOT_LOGIN("", "用户未登录"), 
  USER_LOGIN_EMPTY("", "用户名或密码不能为空"), 
  USER_LOGIN_ERROR("", "用户名或密码错误"), 
  USER_AUTH_FAIL("", "当前用户没有权限"), 
  USER_LOGIN_FORBID("", "当前账号已被禁用，请更换账号登录");

  private String errorCode;
  private String errorMsg;

  private AuthErrorCode(String errorCode, String errorMsg) { this.errorCode = errorCode;
    this.errorMsg = errorMsg;
  }

  public String getErrorCode()
  {
    return this.errorCode;
  }

  public String getErrorMsg() {
    return this.errorMsg;
  }
}