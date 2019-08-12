package com.personal.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.personal.business.dto.MenuTree;
import com.personal.business.entity.BtMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author spk
 * @since 2019-07-16
 */
public interface BtMenuMapper extends BaseMapper<BtMenu> {

    /**
     * @description 根据用户ID查询菜单
     * @auth sunpeikai
     * @param
     * @return
     */
    List<MenuTree> selectMenusByUserId(Integer userId);

    /**
     * 循环父级菜单
     * @author spk
     * @date 2019/5/6 18:06
     */
    List<MenuTree> selectParentMenu(@Param("list") Set<Integer> menuTrees);

    /**
     * @description 获取用户未授权菜单 - 菜单授权
     * @auth sunpeikai
     * @param
     * @return
     */
    List<MenuTree> selectUnAuthorizeMenusByUserId(Integer userId);

    /**
     * @description 取消用户已授权菜单 - 取消授权
     * @auth sunpeikai
     * @param
     * @return
     */
    List<MenuTree> selectAuthorizeMenusByUserId(Integer userId);

}
