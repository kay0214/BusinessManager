package com.personal.business.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangqingqing
 * @version SystemConfig, v0.1 2019/4/3 14:30
 */
@Configuration
@Data
public class SystemConfig {

    @Value("${user.password.defaultPasswordEnabled}")
    private boolean defaultPasswordEnabled;

    @Value("${user.password.defaultPassword}")
    private String defaultPassword;

    @Value("${user.avatar}")
    private String avatar;
}
