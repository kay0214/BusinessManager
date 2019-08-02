/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.personal.business.base.BaseController;
import com.personal.business.base.Return;
import com.personal.business.dto.CompanyDto;
import com.personal.business.entity.BtCompany;
import com.personal.business.enums.ResultEnum;
import com.personal.business.request.CompanyRequest;
import com.personal.business.service.IBtCompanyService;
import com.personal.business.service.IBtDictionaryService;
import com.personal.business.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * @author sunpeikai
 * @version CompanyController, v0.1 2019/8/1 9:34
 * @description
 */
@Slf4j
@Controller
@RequestMapping(value = "/company")
public class CompanyController extends BaseController {

    @Autowired
    private IBtCompanyService iBtCompanyService;

    @Autowired
    private IBtDictionaryService dictionaryService;

    @GetMapping(value = "/init")
    public String init(){
        return "iframe/companyManager";
    }

    @GetMapping(value = "/getAllCompany")
    @ResponseBody
    public Return getAllCompany(CompanyRequest companyRequest){
        IPage<BtCompany> page = iBtCompanyService.getAllCompany(companyRequest);
        return Return.data(page);
    }

    /**
     * @description 插入字典
     * @auth sunpeikai
     * @param
     * @return
     */
    @PostMapping(value = "/insert")
    @ResponseBody
    public Return insert(@RequestBody BtCompany company){
        log.info("insert company [{}]", JSON.toJSONString(company));
        company.setDelFlag(0);
        company.setCreateTime(LocalDateTime.now());
        company.setUpdateTime(LocalDateTime.now());
        boolean success = iBtCompanyService.save(company);
        if(success){
            return Return.success();
        }else{
            return Return.fail("添加失败");
        }
    }

    /**
     * @description 更新字典
     * @auth sunpeikai
     * @param
     * @return
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public Return update(@RequestBody BtCompany company){
        log.info("update company [{}]", JSON.toJSONString(company));
        company.setUpdateTime(LocalDateTime.now());
        boolean success = iBtCompanyService.updateById(company);
        if(success){
            return Return.success();
        }else{
            return Return.fail("添加失败");
        }
    }

    /**
     * @description 批量删除
     * @auth sunpeikai
     * @param
     * @return
     */
    @GetMapping(value = "/delete/{ids}")
    @ResponseBody
    public Return delete(@PathVariable String ids){
        if(!StringUtils.isEmpty(ids)){
            List<String> idsArray = new ArrayList<>();
            Collections.addAll(idsArray, ids.split(","));
            log.info("delete companies [{}]",idsArray);
            boolean success = iBtCompanyService.removeByIds(idsArray);
            if(success){
                return Return.success();
            }else{
                return Return.fail("删除失败");
            }
        }
        return Return.fail(ResultEnum.ERROR_PARAM_NOT_ENOUGH);
    }
}