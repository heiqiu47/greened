package com.qiu.greened.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiu.greened.mapper.PostMapper;
import com.qiu.greened.mapper.ReplyMapper;
import com.qiu.greened.pojo.Post;
import com.qiu.greened.pojo.Reply;
import com.qiu.greened.pojo.vo.ReplyVo;
import com.qiu.greened.service.IReplyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 评论与回复表 服务实现类
 * </p>
 *
 * @author qiu
 * @since 2021-12-09
 */
@Slf4j
@Service
@AllArgsConstructor
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements IReplyService {

    private final ReplyMapper replyMapper;
    private final PostMapper postMapper;

    @Override
    public void addReply(Reply reply) {
        int insert = replyMapper.insert(reply);
        log.info("setReply: " + insert);
        UpdateWrapper<Post> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("post_id", reply.getPostId());
        updateWrapper.setSql("post_reply = post_reply + 1");
        postMapper.update(new Post(), updateWrapper);
    }

    @Override
    public List<ReplyVo> getReplyList(int postId, int page, int limit) {
        IPage<ReplyVo> postPage = replyMapper.getReplyList(new Page<>(page, limit), postId);
        return postPage.getRecords();
    }
}
