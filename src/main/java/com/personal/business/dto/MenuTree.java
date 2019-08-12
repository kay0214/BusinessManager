/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author sunpeikai
 * @version MenuTree, v0.1 2019/7/16 21:09
 * @description
 */
@Data
public class MenuTree implements Serializable {

    /**
     * 菜单ID
     */
    private Integer menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 父菜单ID
     */
    private Integer parentId;

    /**
     * 显示顺序
     */
    private Integer orderNum;

    /**
     * 请求地址
     */
    private String url;

    /**
     * 菜单类型（M目录 C菜单 F权限）
     */
    private String menuType;

    /**
     * 菜单状态（0显示 1隐藏）
     */
    private Integer visible;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 是否默认赋予权限[0:否 ; 1:是]
     */
    private Integer isDefault;

    /**
     * 备注
     */
    private String remark;

    /**
     * 子菜单
     */
    private List<MenuTree> children;
}
