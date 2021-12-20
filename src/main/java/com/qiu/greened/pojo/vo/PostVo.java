package com.qiu.greened.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostVo {

    @ApiModelProperty(value = "动态ID")
    @TableId(value = "post_id", type = IdType.AUTO)
    private Integer postId;

    @ApiModelProperty(value = "动态发布者id")
    private Integer userId;

    @ApiModelProperty(value = "用户名称")
    private String nickName;

    @ApiModelProperty(value = "头像地址")
    private String userAvatar;

    @ApiModelProperty(value = "动态内容")
    private String postContent;

    @ApiModelProperty(value = "动态图片")
    private String postImg;

    @ApiModelProperty(value = "是否点赞")
    private Boolean isStar;

    @ApiModelProperty(value = "点赞数")
    private Integer postStar;

    @ApiModelProperty(value = "评论数")
    private Integer postReply;

    @ApiModelProperty(value = "状态（0正常 1关闭）")
    private String status;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
}
