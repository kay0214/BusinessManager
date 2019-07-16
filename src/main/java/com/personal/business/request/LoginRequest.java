/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.request;

import lombok.Data;

/**
 * @author sunpeikai
 * @version LoginRequest, v0.1 2019/7/16 22:17
 * @description
 */
@Data
public class LoginRequest {

    private String username;
    private String password;
}
