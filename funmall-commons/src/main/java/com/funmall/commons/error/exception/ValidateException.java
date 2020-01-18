package com.funmall.commons.error.exception;

import com.funmall.commons.error.errorCode.GlobalErrorCode;
import com.funmall.commons.error.errorCode.basic.IErrorCodeEnum;

public class ValidateException extends BizException
{
  private static final long serialVersionUID = 1L;

  public ValidateException()
  {
  }

  public ValidateException(IErrorCodeEnum errorCodeEnum)
  {
    super(errorCodeEnum);
  }

  public ValidateException(String errorCode, String errorMsg) {
    super(errorCode, errorMsg);
  }

  public ValidateException(String errorCode, String errorMsg, Throwable cause) {
    super(errorCode, errorMsg, cause);
  }

  public ValidateException(String errorMsg) {
    super(GlobalErrorCode.PARAMS_ERROR.getErrorCode(), errorMsg);
  }
}