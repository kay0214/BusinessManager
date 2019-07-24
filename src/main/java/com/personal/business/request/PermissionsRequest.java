/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.request;

import lombok.Data;

/**
 * @author sunpeikai
 * @version PermissionsRequest, v0.1 2019/7/24 10:01
 * @description
 */
@Data
public class PermissionsRequest {

    private Integer userId;
    /**
     * 菜单权限id列表，用逗号分隔
     * */
    private String ids;
}
