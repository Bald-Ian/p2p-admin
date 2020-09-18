package com.allian.p2p.mapper;

import com.allian.p2p.model.PermissionInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface PermissionInfoMapper {

    //List<PermissionInfo> selectPermissionInfoByuid(Integer userId, Integer parentId);
    PermissionInfo selectPermissionInfoByuid(Integer userId,Integer parentId);

    List<String> selectUrlByuid(Integer userId);
}