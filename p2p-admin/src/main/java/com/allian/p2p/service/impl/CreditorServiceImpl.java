package com.allian.p2p.service.impl;

import com.allian.p2p.mapper.CreditorRightsMapper;
import com.allian.p2p.service.CreditorService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 秃头小岩
 * Ian
 */
@Service
public class CreditorServiceImpl implements CreditorService {
    private RestTemplate restTemplate=new RestTemplate();
    @Resource
    private CreditorRightsMapper creditorRightsMapper;
    @Override
    public List<Map> getContractAll() {
        return creditorRightsMapper.getContractAll(1,1);
    }

    @Override
    public void addContractByCreditorId(Integer creditorId) {
        Object obj=restTemplate.getForObject("http://localhost:8081/seal",Object.class);
    }
}
