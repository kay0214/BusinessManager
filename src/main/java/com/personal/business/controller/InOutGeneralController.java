/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.personal.business.base.BaseController;
import com.personal.business.base.Return;
import com.personal.business.constant.CommonConstant;
import com.personal.business.constant.ShiroPermissionsConstant;
import com.personal.business.dto.InOutGeneralDto;
import com.personal.business.entity.BtInOutGeneral;
import com.personal.business.enums.ResultEnum;
import com.personal.business.request.InOutGeneralRequest;
import com.personal.business.service.IBtInOutGeneralService;
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
 * @version InOutGeneralController, v0.1 2019/9/8 14:53
 * @description
 */
@Slf4j
@Controller
@RequestMapping(value = "/inOutGeneral")
public class InOutGeneralController extends BaseController {

    @Autowired
    private IBtInOutGeneralService iBtInOutGeneralService;

    /**
     * @description 进入出入库概况管理视图
     * @auth sunpeikai
     * @param
     * @return
     */
    @GetMapping(value = "/init")
    public String init(){
        return "iframe/inOutGeneralManager";
    }

    /**
     * @description 出入库概况管理 - 数据表格分页查询
     * @auth sunpeikai
     * @param
     * @return
     */
    @PostMapping(value = "/searchList")
    @ResponseBody
    public Return searchList(@RequestBody InOutGeneralRequest inOutGeneralRequest){
        log.info("search in out general[{}]", JSON.toJSONString(inOutGeneralRequest));
        IPage<BtInOutGeneral> generals = iBtInOutGeneralService.getAllGeneral(inOutGeneralRequest);
        // 实体转换
        IPage<InOutGeneralDto> result = generals.convert(btInOutGeneral -> {
            InOutGeneralDto inOutGeneralDto = CommonUtils.convertBean(btInOutGeneral,InOutGeneralDto.class);
            return inOutGeneralDto;
        });
        return Return.data(result);
    }

    /**
     * @description 更新出入库概况
     * @auth sunpeikai
     * @param
     * @return
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public Return update(@RequestBody BtInOutGeneral general){
        log.info(JSON.toJSONString(general));
        boolean success = iBtInOutGeneralService.updateById(general);
        if(success){
            return Return.success();
        }else{
            return Return.fail("更新失败");
        }
    }

    /**
     * @description 新增出入库概况
     * @auth sunpeikai
     * @param
     * @return
     */
    @PostMapping(value = "/insert")
    @ResponseBody
    public Return insert(@RequestBody BtInOutGeneral general){
        general.setDelFlag(CommonConstant.DEL_FLAG_EXIST);
        general.setCreateTime(LocalDateTime.now());
        general.setUpdateTime(LocalDateTime.now());
        boolean success = iBtInOutGeneralService.save(general);
        if(success){
            return Return.success();
        }else{
            return Return.fail("更新失败");
        }
    }

    /**
     * @description 删除出入库概况
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
            boolean success = iBtInOutGeneralService.removeByIds(idsArray);
            if(success){
                return Return.success();
            }else{
                return Return.fail("删除失败");
            }
        }
        return Return.fail(ResultEnum.ERROR_PARAM_NOT_ENOUGH);
    }
}
