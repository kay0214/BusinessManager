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
 * @version DictionaryExportDto, v0.1 2019/7/29 21:09
 * @description
 */
@Data
@ExcelTarget("BtDictionary")
public class DictionaryExportDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Excel(name = "ID" , width = 20)
    private Integer id;

    /**
     * 字典名称
     */
    @Excel(name = "字典名称" , width = 20)
    private String name;

    /**
     * 排序字段
     */
    @Excel(name = "排序" , width = 20)
    private Integer orderNum;

    /**
     * 父节点id
     */
    @Excel(name = "上级代码" , width = 20)
    private Integer parentId;

    /**
     * 代码
     */
    @Excel(name = "代码" , width = 20)
    private Integer selfId;

    /**
     * 冻结（0：未冻结，1：冻结）
     */
    @Excel(name = "状态" , width = 20 , replace = {"可用_0", "冻结_1"})
    private Integer freeze;

    /**
     * 是否已用（0：未用，1：已用）
     */
    @Excel(name = "已使用" , width = 20 , replace = {"未用_0", "已用_1"})
    private Integer used;

    /**
     * 是否内置（0：否，1：是）
     */
    @Excel(name = "内置" , width = 20 , replace = {"否_0", "是_1"})
    private Integer builtIn;

    /**
     * 暂时保留吧
     */
    private Integer nodeTypeId;

    /**
     * 描述
     */
    @Excel(name = "描述" , width = 20)
    private String remark;

}
