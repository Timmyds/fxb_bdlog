
package com.fxb.blog.controller;

import com.fxb.blog.business.entity.Config;
import com.fxb.blog.business.service.SysConfigService;
import com.fxb.blog.framework.object.ResponseVO;
import com.fxb.blog.util.ResultUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统配置
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/24 14:37
 * @since 1.0
 */
@RestController
@RequestMapping("/config")
public class RestConfigController {
    @Autowired
    private SysConfigService sysConfigService;

    @PostMapping("/get")
    public ResponseVO get() {
        return ResultUtil.success(null, sysConfigService.get());
    }

    @PostMapping("/edit")
    public ResponseVO edit(Config config) {
        try {
            sysConfigService.update(config);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("系统配置修改失败");
        }
        return ResultUtil.success("系统配置修改成功");
    }

}
