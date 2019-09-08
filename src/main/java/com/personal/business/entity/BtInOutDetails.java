package com.personal.business.entity;

import java.math.BigDecimal;
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
public class BtInOutDetails implements Serializable {

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
     * 供应商id
     */
    private Integer companyId;

    /**
     * 供应商名称--冗余
     */
    private String companyName;

    /**
     * 商品唯一编码
     */
    private String goodCode;

    /**
     * 商品分类
     */
    private Integer goodType;

    /**
     * 商品颜色
     */
    private Integer goodColor;

    /**
     * 商品型号
     */
    private Integer goodModel;

    /**
     * 商品品系
     */
    private Integer goodStrain;

    /**
     * 商品预留核算维度1
     */
    private Integer goodReserve1;

    /**
     * 商品预留核算维度2
     */
    private Integer goodReserve2;

    /**
     * 入库数量
     */
    private Integer pushCount;

    /**
     * 出库数量
     */
    private Integer pullCount;

    /**
     * 计量单位
     */
    private Integer unit;

    /**
     * 计价方式
     */
    private Integer pricingMethods;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

    /**
     * 入库总价
     */
    private BigDecimal pushTotalPrice;

    /**
     * 出库总价
     */
    private BigDecimal pullTotalPrice;

    /**
     * 出入库核销数量
     */
    private Integer verifiedCount;

    /**
     * 出入库未核销数量
     */
    private Integer unverifiedCount;

    /**
     * 采购/销售订单核销
     */
    private Integer orderVerifiedCount;

    /**
     * 采购/销售订单未核销
     */
    private Integer orderUnverifiedCount;

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
