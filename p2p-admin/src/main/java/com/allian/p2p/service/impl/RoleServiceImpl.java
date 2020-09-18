package com.allian.p2p.service.impl;

import com.allian.p2p.mapper.RoleInfoMapper;
import com.allian.p2p.model.RoleInfo;
import com.allian.p2p.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 秃头小岩
 * Ian
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleInfoMapper roleInfoMapper;
    @Override
    public List<RoleInfo> selectAll() {
        return roleInfoMapper.selectAll();
    }

    @Override
    public List<Map> selectPermissionByRoleId(Integer roleId) {
        return roleInfoMapper.selectPermissionByRoleId(roleId);
    }

    @Override
    public void disPermisById(Integer roleId, Integer[] permissionIds) {
        roleInfoMapper.deleteAllPermissionByRoleId(roleId);
        if (permissionIds==null){
            return;
        }
        for (Integer permissionId : permissionIds) {
            roleInfoMapper.addPermission(roleId,permissionId);
        }
    }
}
