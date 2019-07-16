package com.personal.business.utils;

import com.personal.business.constant.CommonConstant;

/**
 * @author sunpeikai
 * @version LoginUtils, v0.1 2019/4/4 16:13
 * @description
 */
public class LoginUtils {

    /**
     * @description
     * @auth sunpeikai
     * @param
     * @return
     */
    public static boolean maybeEmail(String email) {
        return email.matches(CommonConstant.EMAIL_PATTERN);
    }

    /**
     * @description
     * @auth sunpeikai
     * @param
     * @return
     */
    public static boolean maybeMobile(String mobile) {
        return mobile.matches(CommonConstant.MOBILE_PHONE_NUMBER_PATTERN);
    }
}
