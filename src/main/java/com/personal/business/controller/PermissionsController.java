/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.controller;

import com.personal.business.Enum.ResultEnum;
import com.personal.business.base.BaseController;
import com.personal.business.base.Return;
import com.personal.business.constant.ShiroPermissionsConstant;
import com.personal.business.request.PermissionsRequest;
import com.personal.business.service.IBtUserMenuService;
import com.personal.business.utils.ShiroUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunpeikai
 * @version PermissionsController, v0.1 2019/7/24 9:58
 * @description
 */
@Slf4j
@RestController
@RequestMapping(value = "/permissions")
public class PermissionsController extends BaseController {

    @Autowired
    private IBtUserMenuService iBtUserMenuService;

    /**
     * @description 用户授权操作
     * @auth sunpeikai
     * @param
     * @return
     */
    @RequiresPermissions(ShiroPermissionsConstant.PERM_MENU_AUTH)
    @PostMapping(value = "/authorize")
    public Return authorize(@RequestBody PermissionsRequest permissionsRequest){
        log.info("authorize userId[{}],menu ids[{}]",permissionsRequest.getUserId(),permissionsRequest.getIds());
        if(!StringUtils.isEmpty(permissionsRequest.getIds())){
            boolean success = iBtUserMenuService.authorize(permissionsRequest);
            if(success){
                ShiroUtils.clearCachedAuthorizationInfo();
                return Return.success();
            }else{
                return Return.fail("授权失败");
            }
        }
        return Return.fail(ResultEnum.ERROR_PARAM_NOT_ENOUGH);
    }

    /**
     * @description 用户取消授权操作
     * @auth sunpeikai
     * @param
     * @return
     */
    @RequiresPermissions(ShiroPermissionsConstant.PERM_MENU_UNAUTH)
    @PostMapping(value = "/unAuthorize")
    public Return unAuthorize(@RequestBody PermissionsRequest permissionsRequest){
        log.info("unAuthorize userId[{}],menu ids[{}]",permissionsRequest.getUserId(),permissionsRequest.getIds());
        if(!StringUtils.isEmpty(permissionsRequest.getIds())) {
            boolean success = iBtUserMenuService.unAuthorize(permissionsRequest);
            if (success) {
                ShiroUtils.clearCachedAuthorizationInfo();
                return Return.success();
            } else {
                return Return.fail("取消授权失败");
            }
        }
        return Return.fail(ResultEnum.ERROR_PARAM_NOT_ENOUGH);
    }
}
