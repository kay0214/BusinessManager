/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.dto;

import lombok.Data;

/**
 * @author sunpeikai
 * @version SelectorDto, v0.1 2019/7/31 14:30
 * @description
 */
@Data
public class SelectorDto {
    // 数据字典下拉框 - key 对应 id
    private Integer key;
    // 数据字典下拉框 - value 对应 name
    private String value;
}
