/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.controller;

import com.personal.business.base.BaseController;
import com.personal.business.base.Return;
import com.personal.business.service.IBtDictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping(value = "/getAllDics")
    @ResponseBody
    public Return getAllDic(){
        return Return.data(iBtDictionaryService.getAllDictionary());
    }
}
