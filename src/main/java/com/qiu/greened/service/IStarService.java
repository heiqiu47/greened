package com.qiu.greened.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiu.greened.pojo.Star;

/**
 * <p>
 * 点赞表 服务类
 * </p>
 *
 * @author qiu
 * @since 2021-12-09
 */
public interface IStarService extends IService<Star> {
    String addOrDeletePostStar(Star star);

    Boolean selUserPostStar(int userId, int postId);
}
