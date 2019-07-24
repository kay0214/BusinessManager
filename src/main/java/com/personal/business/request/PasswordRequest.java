/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.request;

import lombok.Data;

/**
 * @author sunpeikai
 * @version PasswordRequest, v0.1 2019/7/24 12:02
 * @description
 */
@Data
public class PasswordRequest {
    private Integer userId;
    private String oldPassword;
    private String password;
}
