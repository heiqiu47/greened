package com.qiu.greened.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiu.greened.component.ApiException;
import com.qiu.greened.mapper.UserMapper;
import com.qiu.greened.pojo.User;
import com.qiu.greened.pojo.UserDetail;
import com.qiu.greened.pojo.dto.UserLoginDto;
import com.qiu.greened.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * 用户表 服务实现类
 *
 * @author qiu
 * @since 2021-12-09
 */
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService, UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库中查询出用户实体对象
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_phone", username);
        User user = userMapper.selectOne(queryWrapper);
        // 若没查询到抛出该异常，这样才能被Spring Security的错误处理器处理
        if (user == null) {
            throw new UsernameNotFoundException("没有找到该用户");
        }
        // 到这代表查询到了实体对象，那就返回我们自定义的UserDetail对象
        return new UserDetail(user, Collections.emptyList());
    }

    @Override
    public User login(UserLoginDto login) {
        //查询
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_phone", login.getUserPhone());
        User user = userMapper.selectOne(queryWrapper);
        // 若没有查到用户或者密码校验失败，抛出自定义异常
        if (user == null || !passwordEncoder.matches(login.getUserPassword(), user.getUserPassword())) {
            throw new ApiException("账号密码错误");
        }
        return user;
    }

    @Override
    public boolean register(User user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        try {
            userMapper.insert(user);
        } catch (DuplicateKeyException e) {
            throw new ApiException("注册失败, 手机号已存在");
        }
        return true;
    }
}
