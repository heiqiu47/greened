package com.qiu.greened.pojo.vo;

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
 * 评论与回复表
 * </p>
 *
 * @author qiu
 * @since 2021-12-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Reply对象", description = "评论与回复表")
public class ReplyVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论与回复ID")
    @TableId(value = "reply_id", type = IdType.AUTO)
    private Integer replyId;

    @ApiModelProperty(value = "用户名称")
    private String nickName;

    @ApiModelProperty(value = "头像地址")
    private String userAvatar;

    @ApiModelProperty(value = "评论与回复内容")
    private String replyContent;

    @ApiModelProperty(value = "被评论与回复者ID")
    private Integer replyUserId;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
}
