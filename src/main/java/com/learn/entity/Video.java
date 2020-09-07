package com.learn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Video {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("video_id")
    private String videoId;
}
