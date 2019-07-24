/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.Enum;

import java.io.Serializable;

/**
 * @author sunpeikai
 * @version ResultEnum, v0.1 2019/7/16 19:13
 * @description
 */
public enum  ResultEnum implements Serializable {
    SUCCESS_DEFAULT("S001","操作成功"),

    ERROR_DEFAULT("E001","操作失败"),
    ERROR_HAVE_NO_DATA("E002","暂无数据"),

    ERROR_USERNAME_OR_PASSWORD("E010","用户名或密码错误"),
    ERROR_USERNAME_LENGTH("E011","用户名长度不符"),
    ERROR_USER_EXIST("E012","用户不存在或已被禁用"),
    ERROR_VALIDATECODE("E013","图形验证码错误"),
    ERROR_PASSWORD("E014","密码错误"),
    ERROR_NOT_LOGIN("E015","您尚未登录"),
    ERROR_NOT_AUTH("E016","您尚无权限"),


    END("","枚举结束");

    // 成员变量
    private String status;
    private String statusDesc;
    // 构造方法
    ResultEnum(String status, String statusDesc) {
        this.status = status;
        this.statusDesc = statusDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}
