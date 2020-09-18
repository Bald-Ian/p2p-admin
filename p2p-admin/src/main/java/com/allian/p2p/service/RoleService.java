package com.allian.p2p.service;

import com.allian.p2p.model.RoleInfo;

import java.util.List;
import java.util.Map;

/**
 * 秃头小岩
 * Ian
 */
public interface RoleService {
    List<RoleInfo> selectAll();

    List<Map> selectPermissionByRoleId(Integer roleId);

    void disPermisById(Integer roleId, Integer[] permissionId);
}
