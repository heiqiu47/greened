package com.qiu.greened.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author qiu
 * @since 2021-12-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "User对象", description = "用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    @ApiModelProperty(value = "手机号码")
    private String userPhone;

    @ApiModelProperty(value = "密码")
    private String userPassword;

    @ApiModelProperty(value = "用户类型（0系统用户）")
    private String userType;

    @ApiModelProperty(value = "用户名称")
    private String nickName;

    @ApiModelProperty(value = "用户性别（0男 1女 2未知）")
    private String userSex;

    @ApiModelProperty(value = "头像地址")
    private String userAvatar;

    @ApiModelProperty(value = "最后登录时间")
    private LocalDateTime loginDate;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
