/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.service.impl;

import com.personal.business.constant.DictionaryConstant;
import com.personal.business.dto.SelectorDto;
import com.personal.business.service.SelectorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunpeikai
 * @version SelectorServiceImpl, v0.1 2019/8/1 9:36
 * @description
 */
@Slf4j
@Service("selector")
public class SelectorServiceImpl implements SelectorService {

    /**
     * @description 下拉框服务
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public List<SelectorDto> getSelector(String type) {
        return DictionaryConstant.getDictionaries(type);
    }
}
