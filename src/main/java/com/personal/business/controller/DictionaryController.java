/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.controller;

import com.alibaba.fastjson.JSON;
import com.personal.business.base.BaseController;
import com.personal.business.base.Return;
import com.personal.business.constant.CommonConstant;
import com.personal.business.constant.ShiroPermissionsConstant;
import com.personal.business.dto.DictionaryExportDto;
import com.personal.business.entity.BtDictionary;
import com.personal.business.enums.ResultEnum;
import com.personal.business.service.IBtDictionaryService;
import com.personal.business.utils.CheckUtils;
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
 * @version DictionaryController, v0.1 2019/7/29 15:30
 * @description
 */
@Slf4j
@Controller
@RequestMapping(value = "/system/dictionary")
public class DictionaryController extends BaseController {

    @Autowired
    private IBtDictionaryService iBtDictionaryService;

    @GetMapping(value = "/init")
    public String init(){
        return "iframe/dictionaryManager";
    }

    @RequiresPermissions(ShiroPermissionsConstant.PERM_DIC_LIST)
    @GetMapping(value = "/getAllDics")
    @ResponseBody
    public Return getAllDic(){
        return Return.data(iBtDictionaryService.getAllDictionary());
    }

    /**
     * @description 更新字典
     * @auth sunpeikai
     * @param
     * @return
     */
    @RequiresPermissions(ShiroPermissionsConstant.PERM_DIC_EDIT)
    @PostMapping(value = "/update")
    @ResponseBody
    public Return update(@RequestBody BtDictionary dictionary){
        BtDictionary checkDictionary = iBtDictionaryService.getById(dictionary.getId());
        // 内置字典不允许修改个别值
        if(checkDictionary.getBuiltIn().equals(CommonConstant.DICTIONARY_BUILD_IN)){
            // 校验字典区分
            CheckUtils.check(checkDictionary.getType().equals(dictionary.getType()),ResultEnum.ERROR_DICTIONARY_CANNOT_EDIT);
            // 校验字典值
            CheckUtils.check(checkDictionary.getValue().equals(dictionary.getValue()),ResultEnum.ERROR_DICTIONARY_CANNOT_EDIT);
            // 校验内置
            CheckUtils.check(checkDictionary.getBuiltIn().equals(dictionary.getBuiltIn()),ResultEnum.ERROR_DICTIONARY_CANNOT_EDIT);
        }
        boolean success = iBtDictionaryService.updateById(dictionary);
        if(success){
            // 重载字典
            iBtDictionaryService.loadDictionary();
            return Return.success();
        }else{
            return Return.fail("更新失败");
        }
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
    public Return updateNode(@RequestBody BtDictionary dictionary){
        BtDictionary thisNode = iBtDictionaryService.getById(dictionary.getId());
        // 内置字典不允许修改个别值
        if(thisNode.getBuiltIn().equals(CommonConstant.DICTIONARY_BUILD_IN)){
            // 校验字典区分
            CheckUtils.check(thisNode.getType().equals(dictionary.getType()),ResultEnum.ERROR_DICTIONARY_CANNOT_EDIT);
            // 校验字典值
            CheckUtils.check(thisNode.getValue().equals(dictionary.getValue()),ResultEnum.ERROR_DICTIONARY_CANNOT_EDIT);
            // 校验内置
            CheckUtils.check(thisNode.getBuiltIn().equals(dictionary.getBuiltIn()),ResultEnum.ERROR_DICTIONARY_CANNOT_EDIT);
        }
        if(!dictionary.getSelfId().equals(thisNode.getSelfId())){
            List<BtDictionary> children = iBtDictionaryService.getAllChildren(thisNode.getSelfId());
            if(CollectionUtils.isNotEmpty(children)){
                children.forEach(btDictionary->{
                    btDictionary.setParentId(dictionary.getSelfId());
                });
                iBtDictionaryService.updateBatchById(children);
            }
        }
        boolean success = iBtDictionaryService.updateById(dictionary);
        if(success){
            // 重载字典
            iBtDictionaryService.loadDictionary();
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
        BtDictionary dictionary = iBtDictionaryService.getById(id);
        if(dictionary !=null && !dictionary.getSelfId().equals(selfId)){
            boolean exist = iBtDictionaryService.checkExist(selfId);
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
    @RequiresPermissions(ShiroPermissionsConstant.PERM_DIC_ADD)
    @PostMapping(value = "/insert")
    @ResponseBody
    public Return insert(@RequestBody BtDictionary dictionary){
        log.info("insert dictionary [{}]",JSON.toJSONString(dictionary));
        boolean exist = iBtDictionaryService.checkExist(dictionary.getSelfId());
        if(!exist){
            dictionary.setBuiltIn(CommonConstant.DICTIONARY_NOT_BUILD_IN);
            dictionary.setDelFlag(0);
            dictionary.setCreateTime(LocalDateTime.now());
            dictionary.setUpdateTime(LocalDateTime.now());
            boolean success = iBtDictionaryService.save(dictionary);
            if(success){
                // 重载字典
                iBtDictionaryService.loadDictionary();
                return Return.success();
            }else{
                return Return.fail("添加失败");
            }
        }
        return Return.fail(ResultEnum.ERROR_DATA_REPEAT);
    }

    /**
     * @description 删除菜单
     * @auth sunpeikai
     * @param
     * @return
     */
    @RequiresPermissions(ShiroPermissionsConstant.PERM_DIC_DEL)
    @GetMapping(value = "/delete/{ids}")
    @ResponseBody
    public Return delete(@PathVariable String ids){
        if(!StringUtils.isEmpty(ids)){
            CheckUtils.check(!iBtDictionaryService.isBuiltIn(ids),ResultEnum.ERROR_DICTIONARY_CANNOT_DEL);
            List<String> idsArray = new ArrayList<>();
            Collections.addAll(idsArray, ids.split(","));
            log.info("delete dictionary [{}]",idsArray);
            boolean success = iBtDictionaryService.removeByIds(idsArray);
            if(success){
                // 重载字典
                iBtDictionaryService.loadDictionary();
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
    @RequiresPermissions(ShiroPermissionsConstant.PERM_DIC_EXPORT)
    @GetMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response) {
        List<BtDictionary> result = iBtDictionaryService.getAllDictionary();
        if (CollectionUtils.isNotEmpty(result)){
            List<DictionaryExportDto> exportDtos = CommonUtils.convertBeanList(result,DictionaryExportDto.class);
            // 导出数据
            EasyPoiUtil.exportExcel(exportDtos,"数据字典","第一页", DictionaryExportDto.class,"数据字典.xls",response) ;
        }
    }

}
