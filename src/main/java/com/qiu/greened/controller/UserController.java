package com.qiu.greened.controller;


import com.qiu.greened.component.JwtManager;
import com.qiu.greened.pojo.User;
import com.qiu.greened.pojo.dto.UserLoginDto;
import com.qiu.greened.pojo.vo.ResultVo;
import com.qiu.greened.pojo.vo.UserLoginVo;
import com.qiu.greened.service.IUserService;
import com.qiu.greened.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户表 前端控制器
 *
 * @author qiu
 * @since 2021-12-09
 */
@Api(tags = "用户")
@Slf4j
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;
    private final JwtManager jwtManager;

    //@Validated
    @ApiOperation("登录")
    @PostMapping("login")
    public ResultVo<Object> login(@RequestBody UserLoginDto login) {
        User user = userService.login(login);
        // 返回给前端的VO对象
        return ResultGenerator.success("登录成功", new UserLoginVo(
                user.getUserId(), user.getNickName(), user.getUserAvatar(), jwtManager.generate(user.getUserPhone())));
    }

    @ApiOperation("注册")
    @PostMapping("register")
    public ResultVo<Object> register(@RequestBody User user) {
        userService.save(user);
        return ResultGenerator.success("注册成功");
    }
}