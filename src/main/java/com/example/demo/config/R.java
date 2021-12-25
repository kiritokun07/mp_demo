package com.example.demo.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("返回数据Model")
public class R<T> {

    @ApiModelProperty(value = "返回代码，0为成功，其他为错误", example = "0", position = 1)
    private int code;

    @ApiModelProperty(value = "返回信息", example = "success", position = 2)
    private String msg;

    @ApiModelProperty(value = "返回数据", example = "", position = 3)
    private T data;

    public static <T> R<T> newResponse(T data, Integer code, String message) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setMsg(message);
        r.setData(data);
        return r;
    }

    public static <T> R<T> newSuccessResponse(T data) {
        return newResponse(data, 0, "success");
    }

    public static <T> R<T> newFailedResponse(Integer code, String message) {
        return newResponse(null, code, message);
    }

}
