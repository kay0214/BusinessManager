/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.controller;

import com.personal.business.base.BaseController;
import com.personal.business.base.Return;
import com.personal.business.entity.BtUser;
import com.personal.business.request.LoginRequest;
import com.personal.business.utils.ShiroUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunpeikai
 * @version LoginController, v0.1 2019/7/16 19:03
 * @description
 */
@Slf4j
@Controller
@RequestMapping(value = "/system")
public class LoginController extends BaseController {

    @ResponseBody
    @PostMapping(value = "/login")
    public Return<Object> login(@RequestBody LoginRequest loginRequest){
        log.info("login username[{}],password[{}]",loginRequest.getUsername(),loginRequest.getPassword());
        UsernamePasswordToken token = new UsernamePasswordToken(loginRequest.getUsername(),loginRequest.getPassword(),Boolean.FALSE);
        Subject subject = SecurityUtils.getSubject();
        String msg = "";
        try {
            subject.login(token);
            return Return.success();
        } catch (AuthenticationException e) {
            msg = e.getMessage();
        }
        return Return.fail(msg);
    }

    @PostMapping("/logout")
    @ResponseBody
    public Return<Object> logout(){
        //退出操作已经在logout拦截器进行了处理，此处不再重复退出
        return Return.success("退出成功");
    }

    @GetMapping("/test")
    public Return<Object> test(){
        BtUser user = getCurrentUser();
        return Return.data(user);
    }
}
