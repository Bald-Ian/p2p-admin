package com.allian.p2p.service;

import com.allian.p2p.model.PermissionInfo;
import com.allian.p2p.model.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * 秃头小岩
 * Ian
 */
public interface UserService {
    UserInfo selectUserInfoByusername(String username, String password);

    List<UserInfo> selectAllStaff();

    List<Map> getRoleSelectDataByUserId(Integer userId);

    void disRole(Integer userId, Integer[] roleIds);
}
