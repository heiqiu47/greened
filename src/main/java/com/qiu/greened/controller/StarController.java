package com.qiu.greened.controller;


import com.qiu.greened.pojo.Star;
import com.qiu.greened.pojo.vo.ResultVo;
import com.qiu.greened.service.IStarService;
import com.qiu.greened.utils.ResultGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 点赞表 前端控制器
 * </p>
 *
 * @author qiu
 * @since 2021-12-09
 */
@Slf4j
@RestController
@RequestMapping("/post")
@AllArgsConstructor
public class StarController {

    private IStarService starService;

    @PostMapping("/star")
    public ResultVo<Object> addOrDeletePostStar(@RequestBody Star star) {
        String msg = starService.addOrDeletePostStar(star);
        return ResultGenerator.success(msg);
    }
}

