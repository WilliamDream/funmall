package com.funmall.commons.error.exception;


import com.funmall.commons.beans.ResultEntity;
import com.funmall.commons.error.errorCode.basic.IErrorCodeEnum;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ObjectUtils;

public class BusinessException extends RuntimeException
  implements IErrorCodeEnum
{
  private static final long serialVersionUID = 1L;
  protected String errorCode;
  protected String errorMsg;

  protected static final int MIN_AUTO_CODE = 100000;
  protected ResultEntity resultEntity;

  protected BusinessException()
  {
  }

  public BusinessException(IErrorCodeEnum errorCodeEnum)
  {
    super(errorCodeEnum.getErrorCode());
    this.errorCode = errorCodeEnum.getErrorCode();
    this.errorMsg = errorCodeEnum.getErrorMsg();
  }

  public BusinessException(String errorCode, String errorMsg)
  {
    super(errorCode);
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
  }

  public BusinessException(String errorCode, String errorMsg, Throwable cause) {
    super(errorCode, cause);
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
  }

  public static BusinessException create(String message) {
    int value = (int) (MIN_AUTO_CODE + Math.round((Integer.MAX_VALUE - MIN_AUTO_CODE) * Math.random()));
    return create(value + "", message);
  }

  public static BusinessException create(String returnCode, String message) {
    BusinessException businessException = new BusinessException(null);
    businessException.resultEntity = ResultEntity.error(returnCode).message(message);
    return businessException;
  }

  public static BusinessException create(ResultEntity resultEntity) {
    BusinessException businessException = new BusinessException(null);
    businessException.resultEntity = resultEntity;
    return businessException;
  }

  public static BusinessException create(ExceptionCause exceptionCause, Object... args) {
    ResultEntity resultEntity = exceptionCause.result();
    String message = resultEntity.getMessage();

    if (ArrayUtils.isNotEmpty(args)) {
      String[] argsStringArray = new String[args.length];
      for (int i = 0; i < args.length; i++) {
        Object arg = args[i];
        argsStringArray[i] = ObjectUtils.toString(arg);
      }
      String formatMessage = String.format(message, argsStringArray);
      resultEntity.setMessage(formatMessage);
    }

    BusinessException businessException = new BusinessException(null);
    businessException.resultEntity = resultEntity;
    return businessException;
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