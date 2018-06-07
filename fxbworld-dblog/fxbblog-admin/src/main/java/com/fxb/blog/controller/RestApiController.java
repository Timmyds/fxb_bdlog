
package com.fxb.blog.controller;

import com.fxb.blog.business.enums.QiniuUploadType;
import com.fxb.blog.business.service.BizArticleService;
import com.fxb.blog.framework.object.ResponseVO;
import com.fxb.blog.util.FileUtil;
import com.fxb.blog.util.ResultUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 其他api性质的接口
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/24 14:37
 * @since 1.0
 */
@RestController
@RequestMapping("/api")
public class RestApiController {

    @Autowired
    private BizArticleService articleService;

    /**
     * 上传文件到七牛云
     *
     * @param file
     * @return
     */
    @PostMapping("/upload2Qiniu")
    public ResponseVO upload2Qiniu(@RequestParam("file") MultipartFile file) {
        String filePath = FileUtil.uploadToQiniu(file, QiniuUploadType.SIMPLE, false);
        return ResultUtil.success("图片上传成功", filePath);
    }

    /**
     * 发布文章选择图片时获取素材库
     *
     * @return
     */
    @PostMapping("/material")
    public ResponseVO material() {
        return ResultUtil.success("", articleService.listMaterial());
    }
}
