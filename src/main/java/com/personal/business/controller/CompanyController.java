/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.personal.business.base.BaseController;
import com.personal.business.base.Return;
import com.personal.business.constant.CommonConstant;
import com.personal.business.constant.DictionaryConstant;
import com.personal.business.constant.ShiroPermissionsConstant;
import com.personal.business.dto.CompanyExportDto;
import com.personal.business.entity.BtCompany;
import com.personal.business.enums.ResultEnum;
import com.personal.business.request.CompanyRequest;
import com.personal.business.service.IBtCompanyService;
import com.personal.business.utils.CommonUtils;
import com.personal.business.utils.EasyPoiUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @GetMapping(value = "/init")
    public String init(){
        return "iframe/companyManager";
    }

    @RequiresPermissions(ShiroPermissionsConstant.PERM_COMPANY_LIST)
    @GetMapping(value = "/getAllCompany")
    @ResponseBody
    public Return getAllCompany(CompanyRequest companyRequest){
        IPage<BtCompany> page = iBtCompanyService.getAllCompany(companyRequest);
        return Return.data(page);
    }

    /**
     * @description 更新字典
     * @auth sunpeikai
     * @param
     * @return
     */
    @RequiresPermissions(ShiroPermissionsConstant.PERM_DIC_EDIT)
    @PostMapping(value = "/updateNode")
    @ResponseBody
    public Return updateNode(@RequestBody BtCompany company){
        BtCompany thisNode = iBtCompanyService.getById(company.getId());
        if(!company.getSelfId().equals(thisNode.getSelfId())){
            List<BtCompany> children = iBtCompanyService.getAllChildren(thisNode.getSelfId());
            if(CollectionUtils.isNotEmpty(children)){
                children.forEach(btDictionary->{
                    btDictionary.setParentId(company.getSelfId());
                });
                iBtCompanyService.updateBatchById(children);
            }
        }
        boolean success = iBtCompanyService.updateById(company);
        if(success){
            return Return.success();
        }else{
            return Return.fail("更新失败");
        }
    }

    /**
     * @description 检查selfId是否重复
     * @auth sunpeikai
     * @param
     * @return
     */
    @GetMapping(value = "/checkExist/{id}/{selfId}")
    @ResponseBody
    public Return checkExist(@PathVariable Integer id,@PathVariable Integer selfId){
        BtCompany company = iBtCompanyService.getById(id);
        if(company!=null && !company.getSelfId().equals(selfId)){
            boolean exist = iBtCompanyService.checkExist(selfId);
            if(!exist){
                return Return.data(exist);
            }
            return Return.fail(ResultEnum.ERROR_DATA_REPEAT);
        }else{
            return Return.success();
        }

    }

    /**
     * @description 插入字典
     * @auth sunpeikai
     * @param
     * @return
     */
    @RequiresPermissions(ShiroPermissionsConstant.PERM_COMPANY_ADD)
    @PostMapping(value = "/insert")
    @ResponseBody
    public Return insert(@RequestBody BtCompany company){
        log.info("insert company [{}]", JSON.toJSONString(company));
        boolean exist = iBtCompanyService.checkExist(company.getSelfId());
        if(!exist){
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
        return Return.fail(ResultEnum.ERROR_DATA_REPEAT);
    }

    /**
     * @description 更新字典
     * @auth sunpeikai
     * @param
     * @return
     */
    @RequiresPermissions(ShiroPermissionsConstant.PERM_COMPANY_EDIT)
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
    @RequiresPermissions(ShiroPermissionsConstant.PERM_COMPANY_DEL)
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

    /**
     * @description 导出
     * @auth sunpeikai
     * @param
     * @return
     */
    @RequiresPermissions(ShiroPermissionsConstant.PERM_COMPANY_EXPORT)
    @GetMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response) {
        List<BtCompany> result = iBtCompanyService.getAllCompanies();
        if (CollectionUtils.isNotEmpty(result)){
            List<CompanyExportDto> exportDtos = CommonUtils.convertBeanList(result,CompanyExportDto.class);
            exportDtos.forEach(companyExportDto -> {
                companyExportDto.setTypeStr(DictionaryConstant.getValueByTypeAndKey(CommonConstant.DICTIONARY_RELATIONSHIP,companyExportDto.getType()));
                companyExportDto.setStatusStr(DictionaryConstant.getValueByTypeAndKey(CommonConstant.DICTIONARY_STATUS,companyExportDto.getStatus()));
            });
            // 导出数据
            EasyPoiUtil.exportExcel(exportDtos,"往来公司/个人","第一页", CompanyExportDto.class,"往来公司及个人.xls",response) ;
        }
    }

    @ResponseBody
    @GetMapping("/importExcel")
    public void importExcel() {
        List<CompanyExportDto> list = EasyPoiUtil.importExcel("C:\\Users\\dell\\Desktop\\往来公司及个人.xls",1,1,CompanyExportDto.class);
        log.info(JSON.toJSONString(list));
    }
}
