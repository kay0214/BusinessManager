package com.personal.business.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author spk
 * @since 2019-09-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BtInOutGeneral implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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
