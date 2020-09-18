package com.allian.p2p.controller;

import com.allian.p2p.commons.Constans;
import com.allian.p2p.model.PermissionInfo;
import com.allian.p2p.model.UserInfo;
import com.allian.p2p.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 秃头小岩
 * Ian
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/")
    public String index(HttpSession session,Model model){
        UserInfo userInfo = (UserInfo) session.getAttribute(Constans.USER);
        if (userInfo!=null){
            PermissionInfo menu = userInfo.getPermissionInfo();
            model.addAttribute(Constans.MENULIST, menu);
            return "index";
        }


        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session, Model model){
        UserInfo userInfo = userService.selectUserInfoByusername(username,password);

        if (userInfo==null){
            model.addAttribute("errorMessage","登录失败");
            return "login";
        }

        session.setAttribute(Constans.USER, userInfo);
        return "redirect:/";
    }

    @RequestMapping("/permissionError")
    public String error(Model model){
        model.addAttribute(Constans.ERROR,"权限不足，请联系管理员");
        return "MyError";
    }

    @RequestMapping("/admin/users")
    public String user(Model model){
        List<UserInfo> userInfoList = userService.selectAllStaff();
        model.addAttribute("userList",userInfoList);
        return "user";
    }

    @RequestMapping("/admin/toDisRole")
    public String toDisRole(Integer userId, Model model){
        List<Map> list=userService.getRoleSelectDataByUserId(userId);
        model.addAttribute("roleList",list);
        model.addAttribute("userId",userId);
        return "disRole";
    }
    @RequestMapping("/admin/disRole")
    public String disRole(Integer userId,Integer roleIds[]){
        userService.disRole(userId,roleIds);
        return "redirect:/admin/users";
    }
}
