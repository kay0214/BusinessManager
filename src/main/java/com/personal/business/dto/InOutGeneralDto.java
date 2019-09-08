/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author sunpeikai
 * @version UserDto, v0.1 2019/7/23 14:35
 * @description
 */
@Data
public class InOutGeneralDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 核销码
     */
    private String mapCode;

    /**
     * 出库or入库
     */
    private Integer inOut;

    /**
     * 出/入库时间
     */
    private LocalDateTime inOutDate;

    /**
     * 出/入库类型
     */
    private Integer inOutType;

    /**
     * 出/入库订单号
     */
    private String inOutNo;

    /**
     * 当前仓库
     */
    private Integer warehouse;

    /**
     * 供应商id
     */
    private Integer companyId;

    /**
     * 供应商名称--冗余
     */
    private String companyName;

    /**
     * 出入库是否核销完。0否，1是
     */
    private Integer inOutFinish;

    /**
     * 订单核销完。0否，1是
     */
    private Integer orderFinish;

    /**
     * 财务完结。0否，1是
     */
    private Integer financeFinish;

    /**
     * 业务完结。0否，1是
     */
    private Integer businessFinish;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private Integer delFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
