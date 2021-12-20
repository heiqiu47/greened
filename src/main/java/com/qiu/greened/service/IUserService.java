package com.qiu.greened.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiu.greened.pojo.User;
import com.qiu.greened.pojo.dto.UserLoginDto;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author qiu
 * @since 2021-12-09
 */
public interface IUserService extends IService<User> {
    User login(UserLoginDto login);

    boolean register(User user);
}
