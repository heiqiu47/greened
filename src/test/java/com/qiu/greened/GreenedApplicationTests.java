package com.qiu.greened;

import com.qiu.greened.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GreenedApplicationTests {

    @Autowired
    private IUserService userService;

    @Test
    void contextLoads() {
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("user_phone", "15888888888");
//        queryWrapper.eq("user_password", "123456");
//        User user = userService.getOne(queryWrapper,false);
//        System.out.println("************");
//        System.out.println("user -->" + user);
//        System.out.println("************");

    }


}
