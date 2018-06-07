package com.fxb.blog.util;

import java.io.File;
import java.util.Arrays;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fxb.blog.business.enums.QiniuUploadType;
import com.fxb.blog.framework.exception.FileException;
import com.fxb.blog.plugin.QiniuApi;

/**
 * 文件操作工具类
 *
 * @version 1.0
 * @website  
 * @date 2018/01/09 17:40
 * @since 1.0
 */
public class FileUtil {
    private static final String[] PICTURE_SUFFIXS = {".jpg", ".jpeg", ".png", ".gif", ".bmp"};

    /**
     * 删除目录，返回删除的文件数
     *
     * @param rootPath
     *         待删除的目录
     * @param fileNum
     *         已删除的文件个数
     * @return 已删除的文件个数
     */
    public static int deleteFiles(String rootPath, int fileNum) {
        File file = new File(rootPath);
        if (!file.exists()) {
            return -1;
        }
        if (file.isDirectory()) {
            File[] sonFiles = file.listFiles();
            if (sonFiles != null && sonFiles.length > 0) {
                for (File sonFile : sonFiles) {
                    if (sonFile.isDirectory()) {
                        fileNum = deleteFiles(sonFile.getAbsolutePath(), fileNum);
                    } else {
                        sonFile.delete();
                        fileNum++;
                    }
                }
            }
        } else {
            file.delete();
        }
        return fileNum;
    }


    public static String getPrefix(File file) {
        return getPrefix(file.getName());
    }

    public static String getPrefix(String fileName) {
        int idx = fileName.lastIndexOf(".");
        int xie = fileName.lastIndexOf("/");
        idx = idx == -1 ? fileName.length() : idx;
        xie = xie == -1 ? 0 : xie + 1;
        return fileName.substring(xie, idx);
    }

    public static String getSuffix(File file) {
        return getSuffix(file.getName());
    }

    public static String getSuffix(String fileName) {
        int idx = fileName.lastIndexOf(".");
        idx = idx == -1 ? fileName.length() : idx;
        return fileName.substring(idx);
    }

    public static boolean isPicture(String suffix) {
        return !StringUtils.isEmpty(suffix) && Arrays.asList(PICTURE_SUFFIXS).contains(suffix.toLowerCase());
    }

    public static void mkdirs(String filePath) {
        File file = new File(filePath);
        mkdirs(file);
    }

    public static void mkdirs(File file) {
        if (!file.exists()) {
            if (file.isDirectory()) {
                file.mkdirs();
            } else {
                file.getParentFile().mkdirs();
            }
        }
    }

    public static String uploadToQiniu(MultipartFile file, QiniuUploadType uploadType, boolean canBeNull) {
        // 不可为空并且file为空，抛出异常
        if (!canBeNull && null == file) {
            throw new FileException("请选择图片");
        }
        // 可为空并且file为空，忽略后边的代码，返回null
        if (canBeNull && null == file) {
            return null;
        }
        try {
            String filePath = "";
            boolean isPicture = FileUtil.isPicture(FileUtil.getSuffix(file.getOriginalFilename()));
            if (isPicture) {
                filePath = QiniuApi.getInstance()
                        .withFileName(file.getOriginalFilename(), uploadType)
                        .upload(file.getBytes());
                return filePath;
            } else {
                throw new FileException("只支持图片");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileException("上传图片到七牛云发生异常", e);
        }
    }

    /**
     * 删除七牛上的文件
     *
     * @param key
     *         上传成功是返回的文件路径
     * @return
     */
    public static boolean removeQiniu(String key) {
        // 不可为空并且file为空，抛出异常
        if (StringUtils.isEmpty(key)) {
            throw new FileException("删除七牛文件失败:文件key为空");
        }
        try {
            return QiniuApi.getInstance().delete(key);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileException("删除七牛云文件发生异常", e);
        }
    }
}
