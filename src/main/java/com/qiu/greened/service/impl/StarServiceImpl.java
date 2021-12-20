package com.qiu.greened.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiu.greened.mapper.PostMapper;
import com.qiu.greened.mapper.StarMapper;
import com.qiu.greened.pojo.Post;
import com.qiu.greened.pojo.Star;
import com.qiu.greened.service.IStarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 点赞表 服务实现类
 * </p>
 *
 * @author qiu
 * @since 2021-12-09
 */
@Service
@AllArgsConstructor
public class StarServiceImpl extends ServiceImpl<StarMapper, Star> implements IStarService {

    private final StarMapper starMapper;
    private final PostMapper postMapper;

    @Override
    public String addOrDeletePostStar(Star star) {
        QueryWrapper<Star> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", star.getUserId()).eq("post_id", star.getPostId());
        Star one = starMapper.selectOne(queryWrapper);
        String msg;
        UpdateWrapper<Post> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("post_id", star.getPostId());
        if (one == null) {
            starMapper.insert(star);
            updateWrapper.setSql("post_star = post_star + 1");
            postMapper.update(new Post(), updateWrapper);
            msg = "insert";
        } else {
            starMapper.delete(queryWrapper);
            updateWrapper.setSql("post_star = post_star - 1");
            postMapper.update(new Post(), updateWrapper);
            msg = "delete";
        }
        return msg;
    }

    @Override
    public Boolean selUserPostStar(int userId, int postId) {
        boolean star = false;
        QueryWrapper<Star> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("post_id", postId);
        if (starMapper.selectOne(queryWrapper) != null) {
            star = true;
        }
        return star;
    }
}
