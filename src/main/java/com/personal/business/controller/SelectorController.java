/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.controller;

import com.personal.business.base.BaseController;
import com.personal.business.base.Return;
import com.personal.business.service.SelectorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sunpeikai
 * @version SelectorController, v0.1 2019/9/18 16:40
 * @description
 */
@Slf4j
@Controller
@RequestMapping(value = "/system/selector")
public class SelectorController extends BaseController {

    @Autowired
    private SelectorService selectorService;

    @GetMapping(value = "/getSelectorByType/{type}")
    @ResponseBody
    public Return getAllDic(@PathVariable String type){
        return Return.data(selectorService.getSelector(type));
    }
}
