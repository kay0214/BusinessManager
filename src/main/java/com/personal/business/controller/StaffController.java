/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.controller;

import com.personal.business.base.BaseController;
import com.personal.business.base.Return;
import com.personal.business.entity.BtPositionCompany;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunpeikai
 * @version StaffController, v0.1 2019/8/8 19:20
 * @description
 */
@Slf4j
@Controller
@RequestMapping(value = "/staff")
public class StaffController extends BaseController {

    /**
     * @description 添加岗位人员
     * @auth sunpeikai
     * @param
     * @return
     */
    @PostMapping("/insert")
    @ResponseBody
    public Return insert(@RequestBody BtPositionCompany positionCompany){
        log.info("insert staff [{}]",positionCompany);
        return Return.success();
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
        log.info("delete staff {}",ids);
        return Return.success();
    }
}
