package com.learn.utils;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.learn.common.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class VideoUtils {


    /**
     * 流式上传视频接口
     *
     * @param accessKeyId
     * @param accessKeySecret
     * @param title
     * @param fileName
     * @param inputStream
     */
    public static String uploadStream(String accessKeyId, String accessKeySecret, String title, String fileName, InputStream inputStream) {
        UploadStreamRequest request = new UploadStreamRequest(accessKeyId, accessKeySecret, title, fileName, inputStream);
        UploadVideoImpl uploader = new UploadVideoImpl();
        UploadStreamResponse response = uploader.uploadStream(request);
        if (response.isSuccess()) {
            log.info("上传视频成功，videoId : {}", response.getVideoId());
            return response.getVideoId();
        } else {
            log.error("视频上传失败，{}", response.getMessage());
            return "";
        }
    }

    /**
     * 文件上传接口
     * @param accessKeyId
     * @param accessKeySecret
     * @param file
     * @return
     */
    public static String uploadFile(String accessKeyId, String accessKeySecret, MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();
            String title = "";
            if (StringUtils.isNotBlank(fileName)) {
                title = fileName.substring(0, fileName.lastIndexOf(CommonConstant.DOT));
            }
            return uploadStream(accessKeyId, accessKeySecret, title, fileName, inputStream);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return "";
        }
    }
}
