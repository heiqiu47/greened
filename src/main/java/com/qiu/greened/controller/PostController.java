package com.qiu.greened.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiu.greened.pojo.vo.PostVo;
import com.qiu.greened.pojo.vo.ResultVo;
import com.qiu.greened.service.IPostService;
import com.qiu.greened.service.IStarService;
import com.qiu.greened.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 动态表 前端控制器
 * </p>
 *
 * @author qiu
 * @since 2021-12-09
 */
@Slf4j
@Api(tags = "动态")
@RestController
@RequestMapping("/post")
@AllArgsConstructor
public class PostController {

    private IPostService postService;
    private IStarService starService;

    @ApiOperation("热门动态")
    @GetMapping("/nologin/hot")
    public ResultVo<Object> getNoLoginPostList(@RequestParam(value = "page", defaultValue = "1") int page,
                                               @RequestParam(value = "limit", defaultValue = "10") int limit) {
        List<PostVo> records = postService.getPostList(new Page<>(page, limit));
        return ResultGenerator.success(records);
    }

    @ApiOperation("热门动态")
    @GetMapping("/hot")
    public ResultVo<Object> getPostList(@RequestParam(value = "userId") int userId,
                                        @RequestParam(value = "page", defaultValue = "1") int page,
                                        @RequestParam(value = "limit", defaultValue = "10") int limit) {
        List<PostVo> records = postService.getPostList(new Page<>(page, limit));
        //判断是否点赞
        records.forEach(postVo -> postVo.setIsStar(starService.selUserPostStar(userId, postVo.getPostId())));
        return ResultGenerator.success(records);
    }

    @ApiOperation("单个动态")
    @GetMapping("/{postId}")
    public ResultVo<Object> getPostById(@PathVariable int postId, @RequestParam(value = "userId") int userId) {
        PostVo postVo = postService.getPostById(postId);
        postVo.setIsStar(starService.selUserPostStar(userId, postVo.getPostId()));
        return ResultGenerator.success(postVo);
    }
}

