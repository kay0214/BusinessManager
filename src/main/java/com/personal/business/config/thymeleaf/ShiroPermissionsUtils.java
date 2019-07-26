/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.config.thymeleaf;

import com.personal.business.constant.CommonConstant;
import com.personal.business.utils.ShiroUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.Set;

/**
 * @author sunpeikai
 * @version ShiroPermissionsUtils, v0.1 2019/7/26 14:42
 * @description
 */
@Slf4j
public class ShiroPermissionsUtils {

    /**
     * @description 判断用户是否包含某个权限
     * @auth sunpeikai
     * @param
     * @return
     */
    public static String hasPermission(String permission){
        log.info("验证是否有权限[{}]",permission);
        Set<String> permissions = (Set<String>) ShiroUtils.getSession().getAttribute(CommonConstant.SESSION_KEY_PERMISSIONS);
        if(CollectionUtils.isEmpty(permissions)){
            log.info("用户权限列表空");
            return ShiroUtils.getSubject().isPermitted(permission)?"":"disabled";
        }else{
            log.info("用户权限列表{}",permissions);
            return permissions.contains(permission)?"":"disabled";
        }
    }

    /**
     * @description 手动触发shiro权限缓存
     * @auth sunpeikai
     * @param
     * @return
     */
    public static void trigger(){
        hasPermission(CommonConstant.PERMISSION_AUTO_TRIGGER);
    }
}
