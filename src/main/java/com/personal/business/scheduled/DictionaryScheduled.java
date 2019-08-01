/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.scheduled;

import com.alibaba.fastjson.JSON;
import com.personal.business.constant.DictionaryConstant;
import com.personal.business.service.IBtDictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author sunpeikai
 * @version DictionaryScheduled, v0.1 2019/7/31 14:33
 * @description
 */
@Slf4j
@Component
public class DictionaryScheduled {

    @Autowired
    private IBtDictionaryService iBtDictionaryService;

    // 每30分钟重新加载一次数据字典
    @Scheduled(fixedRate = 30 * 60 * 1000)
    public void loadDictionary(){
        log.info("Loading dictionary... Execute every 30 minutes");
        iBtDictionaryService.loadDictionary();
        log.info("Dictionary load over!");
    }
}
