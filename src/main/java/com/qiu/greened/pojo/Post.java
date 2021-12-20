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
 * 动态表
 * </p>
 *
 * @author qiu
 * @since 2021-12-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Post对象", description = "动态表")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "动态ID")
    @TableId(value = "post_id", type = IdType.AUTO)
    private Integer postId;

    @ApiModelProperty(value = "动态发布者id")
    private Integer userId;

    @ApiModelProperty(value = "动态内容")
    private String postContent;

    @ApiModelProperty(value = "动态图片")
    private String postImg;

    @ApiModelProperty(value = "状态（0正常 1关闭）")
    private String status;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
