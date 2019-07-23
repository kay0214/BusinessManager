/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.request;

import com.personal.business.base.BasePage;
import lombok.Data;

/**
 * @author sunpeikai
 * @version UserRequest, v0.1 2019/7/23 14:22
 * @description
 */
@Data
public class UserRequest extends BasePage {
    private String username;
    private String mobile;
    private String email;
    private Integer status;
}
