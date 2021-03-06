
package com.fxb.blog.controller;

import com.fxb.blog.business.annotation.BussinessLog;
import com.fxb.blog.util.ResultUtil;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 页面跳转类
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/24 14:37
 * @since 1.0
 */
@Controller
public class RenderController {

    @BussinessLog("进入首页")
    @GetMapping("")
    public ModelAndView home() {
        return ResultUtil.view("index");
    }

    @BussinessLog("进入首页")
    @GetMapping("/index")
    public ModelAndView index() {
        return ResultUtil.view("index");
    }

    @BussinessLog("进入用户列表页")
    @GetMapping("/users")
    public ModelAndView user() {
        return ResultUtil.view("user/list");
    }

    @BussinessLog("进入资源列表页")
    @GetMapping("/resources")
    public ModelAndView resources() {
        return ResultUtil.view("resources/list");
    }

    @BussinessLog("进入角色列表页")
    @GetMapping("/roles")
    public ModelAndView roles() {
        return ResultUtil.view("role/list");
    }

    @BussinessLog("进入文章列表页")
    @GetMapping("/articles")
    public ModelAndView articles() {
        return ResultUtil.view("article/list");
    }

    @BussinessLog("进入发表文章页")
    @GetMapping("/article/publish")
    public ModelAndView publish() {
        return ResultUtil.view("article/publish");
    }

    @BussinessLog("进入发表文章页")
    @GetMapping("/article/update/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("id", id);
        return ResultUtil.view("article/publish");
    }

    @BussinessLog("进入分类列表页")
    @GetMapping("/article/types")
    public ModelAndView types() {
        return ResultUtil.view("article/types");
    }

    @BussinessLog("进入标签列表页")
    @GetMapping("/article/tags")
    public ModelAndView tags() {
        return ResultUtil.view("article/tags");
    }

    @BussinessLog("进入链接页")
    @GetMapping("/links")
    public ModelAndView links() {
        return ResultUtil.view("link/list");
    }

    @BussinessLog("进入评论页")
    @GetMapping("/comments")
    public ModelAndView comments() {
        return ResultUtil.view("comment/list");
    }

    @BussinessLog("进入系统通知页")
    @GetMapping("/notices")
    public ModelAndView notices() {
        return ResultUtil.view("notice/list");
    }

    @BussinessLog("进入系统配置页")
    @GetMapping("/config")
    public ModelAndView config() {
        return ResultUtil.view("config");
    }

    @BussinessLog("进入模板管理页")
    @GetMapping("/templates")
    public ModelAndView templates() {
        return ResultUtil.view("template/list");
    }

    @BussinessLog("进入更新记录管理页")
    @GetMapping("/updates")
    public ModelAndView updates() {
        return ResultUtil.view("update/list");
    }

    @BussinessLog("进入歌单管理页")
    @GetMapping("/plays")
    public ModelAndView plays() {
        return ResultUtil.view("play/list");
    }

    @BussinessLog("进入静态页面管理页")
    @GetMapping("/sysWebpage")
    public ModelAndView sysWebpage() {
        return ResultUtil.view("sysWebpage/list");
    }

    @GetMapping("/list")
    public ModelAndView list(Model model) {
        return ResultUtil.view("list");
    }

    @GetMapping("/details")
    public ModelAndView detail(Model model) {
        return ResultUtil.view("detail");
    }

    @GetMapping("/ztree")
    public ModelAndView ztree(Model model) {
        return ResultUtil.view("ztree");
    }

    @GetMapping("/icons")
    public ModelAndView icons(Model model) {
        return ResultUtil.view("icons");
    }

    @PostMapping("/getZtree")
    @ResponseBody
    public List<Map<String, Object>> getTree() {
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        for (int i = 0; i < 20; i++) {
            map = new HashMap<>();
            map.put("id", i);
            map.put("pId", (i % 3 > 0 ? i - 1 : 0));
            map.put("checked", (i % 3 > 0 ? i - 1 : 0) != 0);
            map.put("name", "菜单i");
            mapList.add(map);
        }
        return mapList;
    }
}
