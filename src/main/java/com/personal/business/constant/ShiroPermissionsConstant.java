/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.constant;

/**
 * @author sunpeikai
 * @version ShiroPermissionsConstant, v0.1 2019/7/24 13:49
 * @description
 */
public interface ShiroPermissionsConstant {
    /**
     * 权限 - 基础
     */
    String PERM_BASE = "business:";

    /**
     * 权限 - 用户相关
     */
    String PERM_USER = "user:";

    /**
     * 权限 - 菜单相关
     */
    String PERM_MENU = "menu:";

    /**
     * 权限 - 数据字典相关
     */
    String PERM_DIC = "dic:";

    /**
     * 权限 - 查询
     */
    String PERM_LIST = "list";

    /**
     * 权限 - 修改
     */
    String PERM_EDIT = "edit";

    /**
     * 权限 - 新增
     */
    String PERM_ADD = "add";

    /**
     * 权限 - 删除
     */
    String PERM_DEL = "del";

    /**
     * 权限 - 重置
     */
    String PERM_RESET = "reset";

    /**
     * 权限 - 重置
     */
    String PERM_AUTH = "auth";

    /**
     * 权限 - 重置
     */
    String PERM_UNAUTH = "unauth";

    /**
     * 权限 - 导出
     */
    String PERM_EXPORT = "export";

    /**
     * 权限 - 查询用户
     */
    String PERM_USER_LIST = PERM_BASE + PERM_USER + PERM_LIST;

    /**
     * 权限 - 修改用户
     */
    String PERM_USER_EDIT = PERM_BASE + PERM_USER + PERM_EDIT;

    /**
     * 权限 - 新增用户
     */
    String PERM_USER_ADD = PERM_BASE + PERM_USER + PERM_ADD;

    /**
     * 权限 - 删除用户
     */
    String PERM_USER_DEL = PERM_BASE + PERM_USER + PERM_DEL;

    /**
     * 权限 - 删除用户
     */
    String PERM_USER_RESET = PERM_BASE + PERM_USER + PERM_RESET;

    /**
     * 权限 - 查询菜单
     */
    String PERM_MENU_LIST = PERM_BASE + PERM_MENU + PERM_LIST;

    /**
     * 权限 - 修改菜单
     */
    String PERM_MENU_EDIT = PERM_BASE + PERM_MENU + PERM_EDIT;

    /**
     * 权限 - 新增菜单
     */
    String PERM_MENU_ADD = PERM_BASE + PERM_MENU + PERM_ADD;

    /**
     * 权限 - 删除菜单
     */
    String PERM_MENU_DEL = PERM_BASE + PERM_MENU + PERM_DEL;

    /**
     * 权限 - 菜单授权
     */
    String PERM_MENU_AUTH = PERM_BASE + PERM_MENU + PERM_AUTH;

    /**
     * 权限 - 取消授权
     */
    String PERM_MENU_UNAUTH = PERM_BASE + PERM_MENU + PERM_UNAUTH;

    /**
     * 权限 - 查询字典
     */
    String PERM_DIC_LIST = PERM_BASE + PERM_DIC + PERM_LIST;

    /**
     * 权限 - 修改字典
     */
    String PERM_DIC_EDIT = PERM_BASE + PERM_DIC + PERM_EDIT;

    /**
     * 权限 - 新增字典
     */
    String PERM_DIC_ADD = PERM_BASE + PERM_DIC + PERM_ADD;

    /**
     * 权限 - 删除字典
     */
    String PERM_DIC_DEL = PERM_BASE + PERM_DIC + PERM_DEL;

    /**
     * 权限 - 导出字典
     */
    String PERM_DIC_EXPORT = PERM_BASE + PERM_DIC + PERM_EXPORT;
}
