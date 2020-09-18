package com.allian.p2p.controller;

import com.allian.p2p.commons.Constans;
import com.allian.p2p.model.RoleInfo;
import com.allian.p2p.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 秃头小岩
 * Ian
 */
@Controller
public class RolesController {

    @Resource
    private RoleService roleService;

    @RequestMapping("/admin/roles")
    public String roles(Model model){
        List<RoleInfo> list = roleService.selectAll();
        model.addAttribute(Constans.ROLELIST,list);
        return "roles";
    }

    @RequestMapping("/admin/toDisPermis")
    public String toDisPermis(Model model,Integer roleId){

        model.addAttribute("roleId",roleId);
        return "disPermis";
    }

    @RequestMapping("/initPermsTreeByRoleId")
    public @ResponseBody Object
    initPermsTreeByRoleId(Integer roleId){
        List<Map> list = roleService.selectPermissionByRoleId(roleId);
        return list;
    }

    @RequestMapping("/admin/disPermis")
    public @ResponseBody Object
    disPermis(Integer roleId,Integer[] permissionId){

        try {
            roleService.disPermisById(roleId,permissionId);
        } catch (Exception e) {
            e.printStackTrace();
            return "no";
        }


        return "ok";
    }
}
