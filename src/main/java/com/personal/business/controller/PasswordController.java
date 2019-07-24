/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.controller;

import com.personal.business.base.BaseController;
import com.personal.business.base.Return;
import com.personal.business.request.PasswordRequest;
import com.personal.business.service.IBtUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sunpeikai
 * @version PasswordController, v0.1 2019/7/24 11:18
 * @description
 */
@Slf4j
@Controller
@RequestMapping(value = "/password")
public class PasswordController extends BaseController {

    @Autowired
    private IBtUserService iBtUserService;

    @PostMapping(value = "/modifyByOld")
    @ResponseBody
    public Return modifyByOld(@RequestBody PasswordRequest request){
        log.info("modify password by old password,userId[{}],old password[{}],new password[{}]",request.getUserId(),request.getOldPassword(),request.getPassword());
        if(request.getUserId()==null || StringUtils.isEmpty(request.getPassword()) || StringUtils.isEmpty(request.getOldPassword())){
            return Return.fail("参数缺失");
        }
        boolean success = iBtUserService.modifyPasswordByOld(request);
        if(success){
            return Return.success();
        }else{
            return Return.fail("修改密码失败");
        }
    }
}
