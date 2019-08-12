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
 * @since 2019-08-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BtPosition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 岗位名称
     */
    private String name;

    /**
     * 父节点id
     */
    private Integer parentId;

    /**
     * 排序字典
     */
    private Integer orderNum;

    /**
     * 区分部门还是岗位，从数据字典中取得
     */
    private Integer type;

    private Integer status;

    /**
     * 是否已用（0：未用，1：已用）
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
