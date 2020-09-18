package com.allian.p2p.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CreditorRightsMapper {
    List<Map> getContractAll(int collectStatus, int matchStatus);
}