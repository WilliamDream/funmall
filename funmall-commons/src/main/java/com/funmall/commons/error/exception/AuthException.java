package com.funmall.commons.error.exception;


import com.funmall.commons.error.errorCode.AuthErrorCode;

public class AuthException extends BusinessException
{
  private static final long serialVersionUID = 1L;

  public AuthException(AuthErrorCode authErrorCode)
  {
    super(authErrorCode);
  }
}