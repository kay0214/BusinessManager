/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.config.shiro;

import com.personal.business.filter.CaptchaValidateFilter;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author sunpeikai
 * @version ShiroConfig, v0.1 2019/7/16 18:40
 * @description
 */
@Configuration
public class ShiroConfig {

    // 验证码开关
    @Value("${shiro.user.captchaEnabled}")
    private boolean captchaEnabled;

    // Session超时时间，单位为毫秒（默认30分钟）
    @Value("${shiro.session.expireTime}")
    private int expireTime;
    /**
     * 安全管理器
     */
    @Bean
    public SecurityManager securityManager(UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(userRealm);
        // 注入缓存管理器;
        //securityManager.setCacheManager(cacheManager());
        // session管理器
        //securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // Shiro的核心安全接口,这个属性是必须的
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // Shiro连接约束配置，即过滤链的定义
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 退出 logout地址，shiro去清除session
        shiroFilterFactoryBean.setLoginUrl("/system/loginInit");
        filterChainDefinitionMap.put("/system/logout", "logout");
        filterChainDefinitionMap.put("/system/login", "anon,captchaValidate");
        filterChainDefinitionMap.put("/user/password/sendCode", "anon");
        //filterChainDefinitionMap.put("/system/getMenus","authc");
        // shiro 不过滤swagger相关
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
        filterChainDefinitionMap.put("/v2/**", "anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        // 过滤器列表
        Map<String, Filter> filters = new LinkedHashMap<>();
        // 验证码过滤器
        filters.put("captchaValidate", captchaValidateFilter());
        // 登出处理器
        //filters.put("logout", logoutFilter());
        shiroFilterFactoryBean.setFilters(filters);

        return shiroFilterFactoryBean;
    }

    /**
     * 自定义验证码过滤器
     */
    @Bean
    public CaptchaValidateFilter captchaValidateFilter() {
        CaptchaValidateFilter captchaValidateFilter = new CaptchaValidateFilter();
        captchaValidateFilter.setCaptchaEnabled(captchaEnabled);
        return captchaValidateFilter;
    }

    /**
     * 自定义Realm
     */
    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        //userRealm.setCacheManager(cacheManager());
        return userRealm;
    }

    /**
     * 开启Shiro注解通知器
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
