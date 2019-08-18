package com.lyhui.controller;

import com.github.pagehelper.PageInfo;
import com.lyhui.dto.ResponseCode;
import com.lyhui.model.User;
import com.lyhui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
//@RestController   == @Controller + @ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("save")
    public String save(User user) {
        userService.save(user);
        return "user/list";
    }

    @RequestMapping("get/{id}")
    @ResponseBody //测试json返回对象数据
    public User getUser(@PathVariable("id") Integer id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return user;
    }

    @RequestMapping("update")
    public String updateUser(User user) {
        userService.update(user);
        return "user/detail";
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public ResponseCode deleteUser(@PathVariable("id") Integer id) {
        ResponseCode code = userService.deleteUser(id);
        return code;
    }

    @RequestMapping("query")
    @ResponseBody
    public PageInfo query(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize, Model model) {

        PageInfo<User> pageInfo = userService.query(pageNum, pageSize);
        System.out.println(pageInfo);
        return pageInfo;
    }
}
