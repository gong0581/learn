package com.learn.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.learn.common.Result;
import com.learn.entity.Video;
import com.learn.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/video")
@Api("视频控制器")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/test")
    @ApiOperation(value="测试接口文档", notes="测试接口文档")
    public Result test(){
        List<Video> videos = videoService.list(new LambdaQueryWrapper<>());
        return Result.data(videos);
    }
}
