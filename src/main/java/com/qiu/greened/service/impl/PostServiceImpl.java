package com.qiu.greened.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiu.greened.mapper.PostMapper;
import com.qiu.greened.pojo.Post;
import com.qiu.greened.pojo.vo.PostVo;
import com.qiu.greened.service.IPostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 动态表 服务实现类
 * </p>
 *
 * @author qiu
 * @since 2021-12-09
 */
@Service
@AllArgsConstructor
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

    private final PostMapper postMapper;

    @Override
    public List<PostVo> getPostList(Page<?> page) {
        IPage<PostVo> postPage = postMapper.getPostList(page);
        return postPage.getRecords();
    }

    @Override
    public PostVo getPostById(int postId) {
        return postMapper.getPostById(postId);
    }
}
