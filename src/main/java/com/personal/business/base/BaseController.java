/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.base;

import com.personal.business.entity.BtUser;
import com.personal.business.utils.SessionUtils;
import com.personal.business.utils.ShiroUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.UnavailableSecurityManagerException;

/**
 * @author sunpeikai
 * @version BaseController, v0.1 2019/7/16 19:04
 * @description
 */
@Slf4j
public class BaseController {

    public String getIp(){
        return SessionUtils.getIp();
    }

    public String getCurrentUsername(){
        BtUser sysUser = getCurrentUser();
        if(sysUser!=null){
            return getCurrentUser().getUserName();
        }
        return null;
    }

    public Integer getCurrentUserId(){
        BtUser sysUser = getCurrentUser();
        if(sysUser!=null){
            return getCurrentUser().getUserId();
        }
        return null;
    }

    public BtUser getCurrentUser(){
        BtUser sysUser;
        try {
            sysUser = ShiroUtils.getBtUser();
        } catch (UnavailableSecurityManagerException e) {
            log.error(">>>>>>>>shiro未正确启动<<<<<<");
            sysUser = new BtUser();
            sysUser.setUserId(0);
            sysUser.setUserName("静态用户");
        }
        return sysUser;
    }

}
