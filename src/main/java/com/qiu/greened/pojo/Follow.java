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
 * 关注表
 * </p>
 *
 * @author qiu
 * @since 2021-12-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Follow对象", description = "关注表")
public class Follow implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "关注ID")
    @TableId(value = "follow_id", type = IdType.AUTO)
    private Integer followId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "被关注者ID")
    private Integer followUserId;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;


}
