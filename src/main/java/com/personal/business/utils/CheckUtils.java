/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.utils;

import com.personal.business.enums.ResultEnum;
import com.personal.business.exception.BusinessException;
import org.springframework.util.StringUtils;

/**
 * @author sunpeikai
 * @version CheckUtils, v0.1 2019/4/23 17:47
 * @description
 */
public class CheckUtils {
    private static final String defaultDesc = "参数校验失败";

    public static void check(boolean condition){
        check(condition,"");
    }

    public static void check(boolean condition, ResultEnum resultEnum){
        if(!condition){
            throw new BusinessException(resultEnum);
        }
    }

    public static void check(boolean condition,String statusDesc){
        if(!condition){
            if(StringUtils.isEmpty(statusDesc)){
                statusDesc = defaultDesc;
            }
            throw new BusinessException(statusDesc);
        }
    }
}
