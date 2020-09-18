package com.allian.p2p.controller;

import com.allian.p2p.service.CreditorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 秃头小岩
 * Ian
 */
@Controller
public class ContractController {

    @Resource
    private CreditorService creditorService;

    @RequestMapping("/admin/contract")
    public String contract(Model model){
        List<Map> list=creditorService.getContractAll();
        model.addAttribute("creditorList",list);
        return "contract";
    }
    @RequestMapping("/admin/addContract")
    public String addContract(Model model,Integer creditorId){
        creditorService.addContractByCreditorId(creditorId);
        return "redirect:/admin/contract";
    }


}
