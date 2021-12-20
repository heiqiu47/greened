package com.qiu.greened.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginVo {
    private Long userId;
    private String userName;
    private String userAvatar;
    private String token;
}
