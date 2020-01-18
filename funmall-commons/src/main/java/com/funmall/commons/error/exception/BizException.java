package com.funmall.commons.error.exception;


import com.funmall.commons.error.errorCode.basic.IErrorCodeEnum;

public class BizException extends RuntimeException
  implements IErrorCodeEnum
{
  private static final long serialVersionUID = 1L;
  protected String errorCode;
  protected String errorMsg;

  protected BizException()
  {
  }

  public BizException(IErrorCodeEnum errorCodeEnum)
  {
    super(errorCodeEnum.getErrorCode());
    this.errorCode = errorCodeEnum.getErrorCode();
    this.errorMsg = errorCodeEnum.getErrorMsg();
  }

  public BizException(String errorCode, String errorMsg)
  {
    super(errorCode);
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
  }

  public BizException(String errorCode, String errorMsg, Throwable cause) {
    super(errorCode, cause);
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
  }

  public String getErrorCode() {
    return this.errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMsg() {
    return this.errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  public String getMessage() {
    return this.errorMsg;
  }

  public Throwable fillInStackTrace()
  {
    return this;
  }
}