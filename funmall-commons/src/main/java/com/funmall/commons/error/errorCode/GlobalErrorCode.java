package com.funmall.commons.error.errorCode;


import com.funmall.commons.error.errorCode.basic.IErrorCodeEnum;

public enum GlobalErrorCode
  implements IErrorCodeEnum
{
  SYS_EXCEPTION("999", "系统异常"), 
  QUERY_EXCE("901", "加载数据异常"), 
  ADD_EXCE("902", "新增异常"), 
  EXISTS_EXCE("903", "数据已存在"), 
  UPDATE_EXCE("", "更新失败"), 
  DELETE_EXCE("", "更新失败"), 
  UPLOAD_MAX_ERR("", "上传文件超过大小限制"), 
  ENCODE_ERROR("", "加密出错"), 
  DECODE_ERROR("", "解密出错"), 
  PARAMS_ERROR("", "参数错误");

  private String errorCode;
  private String errorMsg;

  private GlobalErrorCode(String errorCode, String errorMsg) { this.errorCode = errorCode;
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