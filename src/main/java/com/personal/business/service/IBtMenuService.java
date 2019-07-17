package com.personal.business.service;

import com.personal.business.dto.MenuTree;
import com.personal.business.entity.BtMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author spk
 * @since 2019-07-16
 */
public interface IBtMenuService extends IService<BtMenu> {

    /**
     * @description 根据userId查询用户权限
     * @auth sunpeikai
     * @param
     * @return
     */
    Set<String> getPermsByUserId(Integer userId);

    /**
     * 根据用户id查询有权限的菜单列表
     * @author zhangyk
     * @date 2019/3/27 14:12
     */
    List<MenuTree> getUserMenus(Integer userId);

}
