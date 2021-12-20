package com.qiu.greened.controller;


import com.qiu.greened.pojo.Reply;
import com.qiu.greened.pojo.vo.ReplyVo;
import com.qiu.greened.pojo.vo.ResultVo;
import com.qiu.greened.service.IReplyService;
import com.qiu.greened.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 评论与回复表 前端控制器
 * </p>
 *
 * @author qiu
 * @since 2021-12-09
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class ReplyController {

    IReplyService replyService;

    @ApiOperation("添加评论")
    @PostMapping("/reply")
    public ResultVo<Object> addReply(@RequestBody Reply reply) {
        replyService.addReply(reply);
        return ResultGenerator.success();
    }

    @ApiOperation("评论列表")
    @GetMapping("/{postId}/reply")
    public ResultVo<Object> getReplyList(@PathVariable int postId,
                                         @RequestParam(value = "page", defaultValue = "1") int page,
                                         @RequestParam(value = "limit", defaultValue = "10") int limit) {
        List<ReplyVo> records = replyService.getReplyList(postId, page, limit);
        return ResultGenerator.success(records);
    }
}

