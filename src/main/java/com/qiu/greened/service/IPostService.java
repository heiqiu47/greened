package com.qiu.greened.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiu.greened.pojo.Post;
import com.qiu.greened.pojo.vo.PostVo;

import java.util.List;

/**
 * <p>
 * 动态表 服务类
 * </p>
 *
 * @author qiu
 * @since 2021-12-09
 */
public interface IPostService extends IService<Post> {
    List<PostVo> getPostList(Page<?> page);

    PostVo getPostById(int postId);

}
