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
 * @version IndexController, v0.1 2019/7/17 9:24
 * @description
 */
@Slf4j
@Controller
@RequestMapping(value = "/")
public class IndexController extends BaseController {

    @GetMapping(value = "/")
    public String init(){
        log.info("entry the index");
        return "index";
    }

    @GetMapping(value = "/iframe")
    public String iframe(){
        log.info("get iframe page");
        return "iframe/iframe";
    }

    @GetMapping(value = "/test2")
    public String test2(){
        log.info("get iframe test2 page");
        return "iframe/test2";
    }
}
