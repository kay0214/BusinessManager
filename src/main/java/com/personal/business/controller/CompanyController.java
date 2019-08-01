/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.personal.business.base.BaseController;
import com.personal.business.base.Return;
import com.personal.business.dto.CompanyDto;
import com.personal.business.entity.BtCompany;
import com.personal.business.request.CompanyRequest;
import com.personal.business.service.IBtCompanyService;
import com.personal.business.service.IBtDictionaryService;
import com.personal.business.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        IPage<CompanyDto> result = page.convert(btCompany -> {
            CompanyDto resultDto = CommonUtils.convertBean(btCompany,CompanyDto.class);
            resultDto.setTypeDesc(dictionaryService.getNameById(resultDto.getType()));
            resultDto.setStatusDesc(dictionaryService.getNameById(resultDto.getStatus()));
            return resultDto;
        });
        return Return.data(result);
    }

}
