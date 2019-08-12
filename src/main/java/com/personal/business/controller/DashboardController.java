/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.controller;

import com.personal.business.base.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sunpeikai
 * @version DashboardController, v0.1 2019/7/22 11:24
 * @description
 */
@Slf4j
@Controller
@RequestMapping(value = "/dashboard")
public class DashboardController extends BaseController {

    @GetMapping(value = "/init")
    public String init(){
        return "iframe/dashboard";
    }
}
