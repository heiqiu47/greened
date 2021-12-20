package com.qiu.greened.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiu.greened.mapper.FollowMapper;
import com.qiu.greened.pojo.Follow;
import com.qiu.greened.service.IFollowService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 关注表 服务实现类
 * </p>
 *
 * @author qiu
 * @since 2021-12-09
 */
@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements IFollowService {

}
