package com.study.common.exception;

import com.study.common.entity.ResultCode;
import lombok.Getter;

// todo : 公共异常
@Getter
public class CommonException extends Exception {

    private ResultCode resultCode;

    public CommonException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
