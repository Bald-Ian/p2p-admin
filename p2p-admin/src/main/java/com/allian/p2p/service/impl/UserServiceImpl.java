package com.allian.p2p.service.impl;

import com.allian.p2p.mapper.PermissionInfoMapper;
import com.allian.p2p.mapper.RoleInfoMapper;
import com.allian.p2p.mapper.UserInfoMapper;
import com.allian.p2p.model.PermissionInfo;
import com.allian.p2p.model.UserInfo;
import com.allian.p2p.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 秃头小岩
 * Ian
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private PermissionInfoMapper permissionInfoMapper;
    @Resource
    private RoleInfoMapper roleInfoMapper;

    @Override
    public UserInfo selectUserInfoByusername(String username, String password) {
        UserInfo userInfo = userInfoMapper.selectUserInfoByusername(username);
        if (userInfo==null){
            return null;
        }
        if (!userInfo.getPassword().equals(password)){
            return null;
        }

        userInfo.setLastLoginTime(new Date());
        userInfo.setLoginCount(userInfo.getLoginCount()==null?1:userInfo.getLoginCount()+1);
        userInfoMapper.updateLoginCountAndLoginTimeById(userInfo);
        PermissionInfo permissionInfo = permissionInfoMapper.selectPermissionInfoByuid(userInfo.getId(), 0);
        userInfo.setPermissionInfo(permissionInfo);
        List<String> list = permissionInfoMapper.selectUrlByuid(userInfo.getId());
        Map<String,String> urlMap = new HashMap<>();
        for (String url : list) {
            urlMap.put(url,"");
        }

        userInfo.setUrlMap(urlMap);

        return userInfo;
    }

    @Override
    public List<UserInfo> selectAllStaff() {
        return userInfoMapper.selectAllStaff();
    }

    @Override
    public List<Map> getRoleSelectDataByUserId(Integer userId) {
        return roleInfoMapper.getRoleSelectDataByUserId(userId);
    }

    @Override
    public void disRole(Integer userId, Integer[] roleIds) {
        roleInfoMapper.deleteRoleByUserId(userId);
        if (roleIds==null){
            return;
        }
        for (Integer roleId : roleIds) {
            roleInfoMapper.addRole(userId,roleId);
        }
    }

}
