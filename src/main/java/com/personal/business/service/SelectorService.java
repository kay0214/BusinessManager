/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.service;

import com.personal.business.dto.SelectorDto;

import java.util.List;

/**
 * @author sunpeikai
 * @version SelectorService, v0.1 2019/8/1 9:35
 * @description
 */
public interface SelectorService {

    /**
     * @description 下拉框服务
     * @auth sunpeikai
     * @param
     * @return
     */
    List<SelectorDto> getSelector(String type);
}
