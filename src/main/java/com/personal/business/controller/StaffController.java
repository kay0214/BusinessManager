/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.controller;

import com.alibaba.fastjson.JSON;
import com.personal.business.base.BaseController;
import com.personal.business.base.Return;
import com.personal.business.entity.BtPositionCompany;
import com.personal.business.enums.ResultEnum;
import com.personal.business.request.PositionCompanyRequest;
import com.personal.business.service.IBtPositionCompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunpeikai
 * @version StaffController, v0.1 2019/8/8 19:20
 * @description
 */
@Slf4j
@Controller
@RequestMapping(value = "/staff")
public class StaffController extends BaseController {

    @Autowired
    private IBtPositionCompanyService iBtPositionCompanyService;

    /**
     * @description 添加岗位人员
     * @auth sunpeikai
     * @param
     * @return
     */
    @PostMapping("/insert")
    @ResponseBody
    public Return insert(@RequestBody PositionCompanyRequest request){
        if(!StringUtils.isEmpty(request.getCompanyIds())){
            String[] companies = request.getCompanyIds().split(",");
            for(String companyId:companies){
                BtPositionCompany positionCompany = new BtPositionCompany();
                positionCompany.setCompanyId(Integer.valueOf(companyId));
                positionCompany.setPositionId(request.getPositionId());
                positionCompany.setCreateTime(LocalDateTime.now());
                iBtPositionCompanyService.save(positionCompany);
            }
            return Return.success();
        }
        return Return.fail(ResultEnum.ERROR_PARAM_NOT_ENOUGH);
    }

    /**
     * @description 删除岗位人员
     * @auth sunpeikai
     * @param
     * @return
     */
    @GetMapping("/delete/{ids}")
    @ResponseBody
    public Return delete(@PathVariable String ids){
        if(!StringUtils.isEmpty(ids)){
            List<Integer> staffIds = new ArrayList<>();
            for(String id:ids.split(",")){
                staffIds.add(Integer.valueOf(id));
            }
            log.info("delete staff {}",JSON.toJSONString(staffIds));
            boolean success = iBtPositionCompanyService.removeByIds(staffIds);
            if(success){
                return Return.success();
            }
            return Return.fail(ResultEnum.ERROR_DEFAULT);
        }
        return Return.fail(ResultEnum.ERROR_PARAM_NOT_ENOUGH);
    }

    /**
     * @description 获取所有未在这个岗位的岗位人员
     * @auth sunpeikai
     * @param
     * @return
     */
    @GetMapping("/getStaffsNotInPosition/{id}")
    @ResponseBody
    public Return getStaffsNotInPosition(@PathVariable Integer id){
        log.info("get staffs not in position {}",id);
        return Return.data(iBtPositionCompanyService.getStaffsNotInPosition(id));
    }
}
