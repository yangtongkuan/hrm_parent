package com.study.common.entity;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/4/9 21:03
 * @To change this template use File | Settings | File Templates.
 */

import com.sun.org.apache.xml.internal.resolver.readers.TR9401CatalogReader;
import sun.font.TrueTypeFont;

/**
 * todo : 公共的返回码
 *
 */
public enum ResultCode {
    SUCCESS(true, 10000, "操作成功"),
    FAIL(false, 10001, "操作失败"),
    UNAUTHENTICATED(false,10002,"您还未登陆"),
    UNAUTHORISE(false,10003,"您还未登陆"),
    SERVER_ERROR(false,99999,"抱歉系统繁忙,请稍后重试~");

    boolean success;
    int code;
    String message;

    ResultCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
