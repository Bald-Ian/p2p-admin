package com.allian.p2p.mapper;

import com.allian.p2p.model.RoleInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleInfoMapper {

    List<RoleInfo> selectAll();

    List<Map> selectPermissionByRoleId(Integer roleId);

    void deleteAllPermissionByRoleId(Integer roleId);

    void addPermission(Integer roleId, Integer permissionId);

    List<Map> getRoleSelectDataByUserId(Integer userId);

    void deleteRoleByUserId(Integer userId);

    void addRole(Integer userId, Integer roleId);
}