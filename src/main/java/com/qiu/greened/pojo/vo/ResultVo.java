package com.qiu.greened.pojo.vo;

import com.qiu.greened.utils.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel
@NoArgsConstructor
public class ResultVo<T> {
    @ApiModelProperty(value = "状态码", notes = "默认200成功")
    private int code;
    @ApiModelProperty(value = "响应信息", notes = "说明响应情况")
    private String msg;
    @ApiModelProperty(value = "响应数据")
    private T data;

    public ResultVo(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

}
