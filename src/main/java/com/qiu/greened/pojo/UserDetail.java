package com.qiu.greened.pojo;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserDetail extends org.springframework.security.core.userdetails.User {
    /**
     * 我们自己的用户实体对象，要调取用户信息时直接获取这个实体对象。
     */
    private final User user;

    public UserDetail(User userEntity, Collection<? extends GrantedAuthority> authorities) {
        // 必须调用父类的构造方法，以初始化用户名、密码、权限
        super(userEntity.getUserPhone(), userEntity.getUserPassword(), authorities);
        this.user = userEntity;
    }
}
