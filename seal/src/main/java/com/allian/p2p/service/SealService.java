package com.allian.p2p.service;


import com.allian.p2p.model.CreditorVO;

/**
 * 合同生成及签章的Service接口
 *
 * @author yanglijun
 */
public interface SealService {

    public String pdfSeal (CreditorVO creditorVO);

}