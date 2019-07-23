/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.utils;

import org.springframework.util.StringUtils;

/**
 * @author sunpeikai
 * @version DataMaskUtils, v0.1 2019/7/23 14:59
 * @description
 */
public class DataMaskUtils {

    /**
     * [身份证号] 前三 后四<例子:123**********1234>
     * @param idCard
     * @return
     */
    public static String idCard(final String idCard){
        if(StringUtils.isEmpty(idCard) || (idCard.length() < 18)){
            return "";
        }
        return replace(idCard,"(?<=\\w{3})\\w(?=\\w{4})");
    }

    /**
     * [手机号码] 前三位，后四位<例子:138****1234>
     */
    public static String mobile(final String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return "";
        }
        return replace(mobile,"(?<=\\w{3})\\w(?=\\w{4})");
    }

    /**
     * [电子邮箱] 前一位，@及后地址<例子:g**@163.com>
     */
    public static String email(final String email) {
        if (StringUtils.isEmpty(email)) {
            return "";
        }
        final int index = email.indexOf("@");
        if (index <= 1) {
            return email;
        } else {
            return replace(email.substring(0,index),"(?<=\\w{1})\\w(?=\\w{0})") + email.substring(index);
        }
    }

    /**
     * [银行卡号] 前六位，后四位<例子:6222600**********1234>
     */
    public static String bankCard(final String cardNum) {
        if (StringUtils.isEmpty(cardNum)) {
            return "";
        }
        return replace(cardNum,"(?<=\\w{6})\\w(?=\\w{4})");
    }

    private static String replace(final String replace,final String regex){
        return replace.replaceAll(regex,"*");
    }
}
