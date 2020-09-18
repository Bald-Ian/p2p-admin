package com.allian.p2p.controller;

import com.allian.p2p.model.CreditorVO;
import com.allian.p2p.service.SealService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 秃头小岩
 * Ian
 */
@Controller
public class SealController {
    @Resource
    private SealService sealService;
    @RequestMapping("/seal")
    public Object seal(){
        System.out.println("进入签章系统");
        CreditorVO creditorVO=new CreditorVO();
        creditorVO.setApplyNo("A0001");
        creditorVO.setApplyPurpose("买手机");
        creditorVO.setAuditLoanMoney(new BigDecimal(12000));
        creditorVO.setAuditLoanTerm(5);
        creditorVO.setBorrowerIdcard("123456789");
        creditorVO.setBorrowerPresentAddress("北京大兴");
        creditorVO.setBorrowerRealname("张三");
        creditorVO.setBorrowerSex(1);
        creditorVO.setCollectFinishTime(new Date());
        String url=sealService.pdfSeal(creditorVO);
        return url;
    }
}
