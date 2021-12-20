package com.qiu.greened.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiu.greened.pojo.Reply;
import com.qiu.greened.pojo.vo.ReplyVo;

/**
 * <p>
 * 评论与回复表 Mapper 接口
 * </p>
 *
 * @author qiu
 * @since 2021-12-09
 */
public interface ReplyMapper extends BaseMapper<Reply> {
    IPage<ReplyVo> getReplyList(Page<?> page, int postId);

}
