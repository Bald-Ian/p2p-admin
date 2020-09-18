package com.allian.p2p.mapper;

import com.allian.p2p.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    UserInfo selectUserInfoByusername(String username);

    void updateLoginCountAndLoginTimeById(UserInfo userInfo);

    List<UserInfo> selectAllStaff();
}