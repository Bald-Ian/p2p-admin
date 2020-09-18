package com.allian.p2p.service;

import java.util.List;
import java.util.Map;

/**
 * 秃头小岩
 * Ian
 */
public interface CreditorService {
    List<Map> getContractAll();

    void addContractByCreditorId(Integer creditorId);
}
