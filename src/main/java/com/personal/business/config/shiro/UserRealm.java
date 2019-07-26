package com.personal.business.config.shiro;

import com.personal.business.constant.CommonConstant;
import com.personal.business.entity.BtUser;
import com.personal.business.service.IBtMenuService;
import com.personal.business.service.IBtUserService;
import com.personal.business.utils.ShiroUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * 自定义Realm 处理登录 权限
 *
 * @author framework
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {


    @Autowired
    private IBtMenuService iBtMenuService;

    @Autowired
    private IBtUserService iBtUserService;


    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        BtUser user = ShiroUtils.getBtUser();
        log.info("userRealm:shiro缓存用户[userId:{}]操作权限",user.getUserId());
        // 角色列表
        //Set<String> roles = new HashSet<String>();
        // 功能列表
        Set<String> menus = new HashSet<String>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 查询用户的所有角色
        //roles = roleService.selectRolesByUserId(user);

        menus = iBtMenuService.getPermsByUserId(user.getUserId());
        // 角色加入AuthorizationInfo认证对象
        //info.setRoles(roles);
        // 权限加入AuthorizationInfo认证对象
        info.setStringPermissions(menus);
        // 缓存权限
        ShiroUtils.setSessionAttribute(CommonConstant.SESSION_KEY_PERMISSIONS,menus);
        return info;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        String password = "";
        if (upToken.getPassword() != null) {
            password = new String(upToken.getPassword());
        }

        BtUser user = null;
        try {
            user = iBtUserService.login(username, password);
        } catch (Exception e) {
            log.info("对用户[" + username + "]进行登录验证..验证未通过:{}", e.getMessage());
            throw new AuthenticationException(e.getMessage(), e);
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }

    /**
     * 清理缓存权限
     */
    public void clearCachedAuthorizationInfo() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}
