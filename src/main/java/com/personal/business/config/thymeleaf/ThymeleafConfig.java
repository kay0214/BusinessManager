/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.config.thymeleaf;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunpeikai
 * @version ThymeleafConfig, v0.1 2019/7/26 14:49
 * @description
 */
@Configuration
public class ThymeleafConfig {
    @Bean
    @ConditionalOnMissingBean
    public ShiroPermissionsDialect shiroPermissionsDialect(){
        return new ShiroPermissionsDialect();
    }
}
