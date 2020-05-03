package com.funmall.commons.beans;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 普通消息返回
 *
 * @param <T>
 */
public class ResultEntity<T> implements Serializable {
    @ApiModelProperty("返回码(0:成功,非0:失败)")
    private String code = "0";
    @ApiModelProperty("返回消息")
    private String message;
    @ApiModelProperty("附加信息")
    private T data;

    public ResultEntity() {
        this.message = "success";
    }

    public ResultEntity(T data) {
        this();
        this.data = data;
    }

    public static ResultEntity success() {
        return new ResultEntity();
    }

    public static ResultEntity error(String returnCode) {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setCode(returnCode);
        resultEntity.setMessage("fail");
        return resultEntity;
    }

    public static ResultEntity error() {
        return error("-1");
    }

    public ResultEntity message(String msg) {
        this.message = msg;
        return this;
    }

    public ResultEntity data(T data) {
        this.data = data;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    /**
     * 判断模块调用成功
     *
     * @return
     */
    public boolean isSuccess() {
        return "0".equals(code);
    }
}