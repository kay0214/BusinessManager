/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.controller;

import com.alibaba.fastjson.JSON;
import com.personal.business.base.BaseController;
import com.personal.business.base.Return;
import com.personal.business.entity.BtPosition;
import com.personal.business.service.IBtPositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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

    @GetMapping("/init")
    public String init(){
        return "iframe/positionManager";
    }

    @GetMapping("/getAllPositions")
    @ResponseBody
    public Return getAllPositions(){
        return Return.data(iBtPositionService.getAllPositions());
    }

    /**
     * @description 更新字典
     * @auth sunpeikai
     * @param
     * @return
     */
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
}
