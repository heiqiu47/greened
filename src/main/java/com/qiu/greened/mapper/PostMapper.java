package com.qiu.greened.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiu.greened.pojo.Post;
import com.qiu.greened.pojo.vo.PostVo;

/**
 * <p>
 * 动态表 Mapper 接口
 * </p>
 *
 * @author qiu
 * @since 2021-12-09
 */
public interface PostMapper extends BaseMapper<Post> {

    IPage<PostVo> getPostList(Page<?> page);

    PostVo getPostById(int postId);

}
