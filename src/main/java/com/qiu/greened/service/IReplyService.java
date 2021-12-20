package com.qiu.greened.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiu.greened.pojo.Reply;
import com.qiu.greened.pojo.vo.ReplyVo;

import java.util.List;

/**
 * <p>
 * 评论与回复表 服务类
 * </p>
 *
 * @author qiu
 * @since 2021-12-09
 */
public interface IReplyService extends IService<Reply> {

    void addReply(Reply reply);

    List<ReplyVo> getReplyList(int postId, int page, int limit);


}
