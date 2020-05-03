package com.funmall.commons.error.exception;

import com.funmall.commons.beans.ResultEntity;

public interface ExceptionCause<T extends Exception> {

    /**
     * 创建异常
     *
     * @return
     */
    T exception(Object... args);

    ResultEntity result();
}
