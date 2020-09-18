package com.allian.p2p.mapper;

import com.allian.p2p.model.StaffInfo;

public interface StaffInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StaffInfo record);

    int insertSelective(StaffInfo record);

    StaffInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StaffInfo record);

    int updateByPrimaryKey(StaffInfo record);
}