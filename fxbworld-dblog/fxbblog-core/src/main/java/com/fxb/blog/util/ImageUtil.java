package com.fxb.blog.util;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.fxb.blog.business.entity.ImageFileInfo;
import com.fxb.blog.framework.exception.FileException;

/**
 * 操作图片工具类
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/18 11:48
 * @since 1.0
 */
public class ImageUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ImageUtil.class);

    /**
     * 获取图片信息
     *
     * @param file
     * @throws IOException
     */
    public static ImageFileInfo getInfo(File file) {
        if (null == file) {
            return null;
        }
        try {
            return getInfo(new FileInputStream(file))
                    .withSize(file.length())
                    .withFilename(file.getName())
                    .withType(FileUtil.getSuffix(file.getName()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileException("获取图片信息发生异常！", e);
        }
    }

    /**
     * 获取图片信息
     *
     * @param multipartFile
     * @throws IOException
     */
    public static ImageFileInfo getInfo(MultipartFile multipartFile) {
        if (null == multipartFile) {
            return null;
        }
        try {
            return getInfo(multipartFile.getInputStream())
                    .withSize(multipartFile.getSize())
                    .withFilename(multipartFile.getOriginalFilename())
                    .withType(FileUtil.getSuffix(multipartFile.getOriginalFilename()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileException("获取图片信息发生异常！", e);
        }
    }

    /**
     * 获取图片信息
     *
     * @param inputStream
     * @throws IOException
     */
    public static ImageFileInfo getInfo(InputStream inputStream) {
        try (BufferedInputStream in = new BufferedInputStream(inputStream)) {
            //字节流转图片对象
            Image bi = ImageIO.read(in);
            //获取默认图像的高度，宽度
            return new ImageFileInfo(bi.getWidth(null), bi.getHeight(null));
        } catch (Exception e) {
            LOG.error("获取图片信息失败", e);
        }
        return new ImageFileInfo();
    }
}
