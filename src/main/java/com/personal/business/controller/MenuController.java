/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.controller;

import com.personal.business.base.BaseController;
import com.personal.business.base.Return;
import com.personal.business.service.IBtMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sunpeikai
 * @version MenuController, v0.1 2019/7/17 10:15
 * @description
 */
@Slf4j
@Controller
@RequestMapping(value = "/system/menu")
public class MenuController extends BaseController {

    @Autowired
    private IBtMenuService iBtMenuService;

    @GetMapping(value = "/init")
    public String init(){
        return "iframe/menuManager";
    }

    @GetMapping(value = "/getMenus")
    @ResponseBody
    public Return getMenus(){
        Integer userId = getCurrentUserId();
        log.info("get user menus , userId:[{}]",userId);
        return Return.data(iBtMenuService.getUserMenus(userId));
    }

    @GetMapping(value = "/getAllMenus")
    @ResponseBody
    public Return getAllMenus(){
        log.info("get all menus");
        return Return.data(iBtMenuService.list());
    }
}
