package com.qiu.greened.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StarDto {
    @ApiModelProperty(value = "用户id")
    private int userId;
    @ApiModelProperty(value = "动态id")
    private int postId;
}
