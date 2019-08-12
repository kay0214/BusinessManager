package com.personal.business.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author spk
 * @since 2019-07-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BtDictionary implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 字典区分
     */
    private String type;

    /**
     * 字典值
     */
    private Integer value;

    /**
     * 字典名称
     */
    private String name;

    /**
     * 排序字段
     */
    private Integer orderNum;

    /**
     * 父节点id
     */
    private Integer parentId;

    /**
     * 自身节点id
     */
    private Integer selfId;

    /**
     * 冻结（0：未冻结，1：冻结）
     */
    private Integer freeze;

    /**
     * 是否已用（0：未用，1：已用）
     */
    private Integer used;

    /**
     * 是否内置（0：否，1：是）
     */
    private Integer builtIn;

    /**
     * 暂时保留吧
     */
    private Integer nodeTypeId;

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
