package com.funmall.commons.error;

import com.funmall.commons.error.errorCode.GlobalErrorCode;
import com.funmall.commons.error.exception.AuthException;
import com.funmall.commons.error.exception.BizException;
import com.funmall.commons.vo.ResultVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler
{
  private static Log log = LogFactory.getLog(GlobalExceptionHandler.class);

  @ExceptionHandler({BizException.class})
  @ResponseBody
  public ResultVo bizExceptionHandler(HttpServletRequest req, Exception e) { BizException ex = (BizException)e;
    ResultVo result = ResultVo.error(ex);
    return result; } 
  @ExceptionHandler({AuthException.class})
  @ResponseBody
  public ResultVo authExceptionHandler(HttpServletRequest req, Exception e) {
    AuthException ex = (AuthException)e;
    ResultVo result = ResultVo.authError(ex);
    return result;
  }
  @ExceptionHandler({Exception.class})
  @ResponseBody
  public ResultVo exceptionHandler(HttpServletRequest req, Exception e) { log.error(e.getMessage(), e);
    ResultVo result = ResultVo.error(GlobalErrorCode.SYS_EXCEPTION);
    return result; } 
  @ExceptionHandler({DuplicateKeyException.class})
  @ResponseBody
  public ResultVo dataExistsHandler(HttpServletRequest req, Exception e) {
    log.error(e.getMessage(), e);
    ResultVo result = ResultVo.error(GlobalErrorCode.EXISTS_EXCE);
    return result;
  }
}