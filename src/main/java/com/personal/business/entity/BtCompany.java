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
 * @since 2019-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BtCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 公司助记代码
     */
    private String companyCode;

    /**
     * 财务系统代码
     */
    private String accountCode;

    /**
     * 类型-从数据字典录入
     */
    private Integer type;

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
     * 父节点id
     */
    private Integer parentId;

    /**
     * 自身节点id
     */
    private Integer selfId;

    /**
     * 启用
     */
    private Integer status;

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
