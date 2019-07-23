/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.base;

import lombok.Data;

/**
 * @author sunpeikai
 * @version BasePage, v0.1 2019/7/23 14:38
 * @description
 */
@Data
public class BasePage {
    private Integer page;
    private Integer limit;
}
