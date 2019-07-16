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

/*
    @Value("${aes.localKey}")
    private String localKey;

    @Value("${aes.localIV}")
    private String localIV;

    @Value("${ncbx.best.host}")
    private String bestHost;
*/

    @Value("${aliyun.sms.templateCode.register}")
    private String registerTemplateCode;

    @Value("${aliyun.sms.templateCode.findPassword}")
    private String findPasswordTemplateCode;

    @Value("${aliyun.sms.templateCode.resetPassword}")
    private String resetPassword;

    @Value("${hyjf.defaultRowMaxCount}")
    private Integer defaultRowMaxCount;
    //员工入职短信模版 告知登录名和密码
    @Value("${aliyun.sms.templateCode.staffEntry}")
    private String staffEntryTemplateCode;

    @Value("${ncbx.admin.best.host}")
    private String adminBestHost;

    @Value("${ncbx.app.best.host}")
    private String appBestHost;
}
