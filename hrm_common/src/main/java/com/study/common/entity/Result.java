package com.study.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/4/9 21:14
 * @To change this template use File | Settings | File Templates.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    @ApiModelProperty("成功")
    private boolean success;           // 成功信息
    @ApiModelProperty("状态码")
    private Integer code;               // code
    @ApiModelProperty("提示信息")
    private String message;             // 提示信息
    @ApiModelProperty("数据信息")
    private T data;                     // 数据

    public Result(ResultCode code) {
        this.success = code.success;
        this.code = code.code;
        this.message = code.message;
    }

    public Result(ResultCode code, T data) {
        this.success = code.success;
        this.code = code.code;
        this.message = code.message;
        this.data = data;
    }
    public Result(boolean success, int code, String message) {
        this(success, code, message, null);
    }
}
