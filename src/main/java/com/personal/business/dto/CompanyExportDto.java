/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author sunpeikai
 * @version CompanyExportDto, v0.1 2019/8/12 14:41
 * @description
 */
@Data
@ExcelTarget("BtCompany")
public class CompanyExportDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公司助记代码
     */
    @Excel(name = "助记代码" , width = 20)
    private String companyCode;

    /**
     * 财务系统代码
     */
    @Excel(name = "财务系统代码" , width = 20)
    private String accountCode;

    /**
     * 类型-从数据字典录入
     */
    private Integer type;

    @Excel(name = "类型" , width = 20)
    private String typeStr;

    /**
     * 公司信用代码/个人身份证号码
     */
    @Excel(name = "证件号" , width = 20)
    private String creditCode;

    /**
     * 公司全称/个人姓名
     */
    @Excel(name = "全称" , width = 20)
    private String fullName;

    /**
     * 公司简称
     */
    @Excel(name = "简称" , width = 20)
    private String shortName;

    /**
     * 父节点id
     */
    @Excel(name = "上级代码" , width = 20)
    private Integer parentId;

    /**
     * 自身节点id
     */
    @Excel(name = "代码" , width = 20)
    private Integer selfId;

    /**
     * 启用
     */
    private Integer status;

    @Excel(name = "状态" , width = 20)
    private String statusStr;

    /**
     * 已被使用(0：否，1：是)
     */
    @Excel(name = "已使用" , width = 20 , replace = {"未用_0", "已用_1"})
    private Integer used;

    /**
     * 描述
     */
    @Excel(name = "描述" , width = 20)
    private String remark;

    @Excel(name = "创建时间" , width = 20, format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
