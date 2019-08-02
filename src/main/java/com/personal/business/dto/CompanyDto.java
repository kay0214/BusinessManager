/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author sunpeikai
 * @version CompanyDto, v0.1 2019/8/1 10:39
 * @description
 */
@Data
public class CompanyDto {
    private Integer id;

    /**
     * 公司助记代码
     */
    private String companyCode;

    /**
     * 类型-从数据字典录入
     */
    private Integer type;

    /**
     * 类型-描述
     */
    private String typeDesc;

    /**
     * 公司信用代码/个人身份证号码
     */
    private String creditCode;

    /**
     * 公司全称/个人姓名
     */
    private String fullName;

    /**
     * 公司简称
     */
    private String shortName;

    /**
     * 启用
     */
    private Integer status;

    /**
     * 启用描述
     */
    private String statusDesc;

    /**
     * 已被使用(0：否，1：是)
     */
    private Integer used;

    /**
     * 描述
     */
    private String remark;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private Integer delFlag;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
