/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.controller;

import com.alibaba.fastjson.JSON;
import com.personal.business.base.BaseController;
import com.personal.business.base.Return;
import com.personal.business.constant.ShiroPermissionsConstant;
import com.personal.business.dto.PositionDto;
import com.personal.business.dto.StaffDto;
import com.personal.business.entity.BtPosition;
import com.personal.business.enums.ResultEnum;
import com.personal.business.request.StaffRequest;
import com.personal.business.service.IBtPositionCompanyService;
import com.personal.business.service.IBtPositionService;
import com.personal.business.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sunpeikai
 * @version PositionController, v0.1 2019/8/5 9:19
 * @description
 */
@Slf4j
@Controller
@RequestMapping(value = "/position")
public class PositionController extends BaseController {

    @Autowired
    private IBtPositionService iBtPositionService;
    @Autowired
    private IBtPositionCompanyService iBtPositionCompanyService;

    @GetMapping("/init")
    public String init(){
        return "iframe/positionManager";
    }

    @RequiresPermissions(ShiroPermissionsConstant.PERM_POSITION_LIST)
    @GetMapping("/getAllPositions")
    @ResponseBody
    public Return getAllPositions(){
        log.info("search all positions");
        List<BtPosition> positions = iBtPositionService.getAllPositions();
        List<StaffDto> staffDtos = iBtPositionCompanyService.getStaffsByPositionId(null);
        List<PositionDto> results = CommonUtils.convertBeanList(positions,PositionDto.class);
        results.forEach(positionDto -> {
            List<String> staffs = new ArrayList<>();
            staffDtos.forEach(staffDto -> {
                if(positionDto.getId().equals(staffDto.getPositionId())){
                    staffs.add(staffDto.getCompanyName());
                }
            });
            positionDto.handleStaffs(staffs);
        });
        return Return.data(results);
    }

    /**
     * @description 更新字典
     * @auth sunpeikai
     * @param
     * @return
     */
    @RequiresPermissions(ShiroPermissionsConstant.PERM_POSITION_EDIT)
    @PostMapping(value = "/update")
    @ResponseBody
    public Return update(@RequestBody BtPosition position){
        log.info("update company [{}]", JSON.toJSONString(position));
        position.setUpdateTime(LocalDateTime.now());
        boolean success = iBtPositionService.updateById(position);
        if(success){
            return Return.success();
        }else{
            return Return.fail("添加失败");
        }
    }

    /**
     * @description 插入字典
     * @auth sunpeikai
     * @param
     * @return
     */
    @RequiresPermissions(ShiroPermissionsConstant.PERM_POSITION_ADD)
    @PostMapping(value = "/insert")
    @ResponseBody
    public Return insert(@RequestBody BtPosition position){
        log.info("insert position [{}]", JSON.toJSONString(position));
        position.setDelFlag(0);
        position.setCreateTime(LocalDateTime.now());
        position.setUpdateTime(LocalDateTime.now());
        boolean success = iBtPositionService.save(position);
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
    @RequiresPermissions(ShiroPermissionsConstant.PERM_POSITION_DEL)
    @GetMapping(value = "/delete/{ids}")
    @ResponseBody
    public Return delete(@PathVariable String ids){
        if(!StringUtils.isEmpty(ids)){
            List<String> idsArray = new ArrayList<>();
            Collections.addAll(idsArray, ids.split(","));
            log.info("delete companies [{}]",idsArray);
            boolean success = iBtPositionService.removeByIds(idsArray);
            if(success){
                return Return.success();
            }else{
                return Return.fail("删除失败");
            }
        }
        return Return.fail(ResultEnum.ERROR_PARAM_NOT_ENOUGH);
    }

    /**
     * @description 根据positionId获取员工信息
     * @auth sunpeikai
     * @param
     * @return
     */
    @RequiresPermissions(ShiroPermissionsConstant.PERM_POSITION_INFO_LIST)
    @GetMapping(value = "/staffInfo")
    @ResponseBody
    public Return staffInfo(StaffRequest request){
        log.info("search staff positionId[{}],page[{}],limit[{}]",request.getPositionId(),request.getPage(),request.getLimit());
        if(!StringUtils.isEmpty(request.getPositionId())){
            return Return.data(iBtPositionCompanyService.getStaffByPositionId(request));
        }
        return Return.fail(ResultEnum.ERROR_PARAM_NOT_ENOUGH);
    }
}
