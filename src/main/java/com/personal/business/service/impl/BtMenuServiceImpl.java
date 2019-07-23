package com.personal.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.personal.business.constant.CommonConstant;
import com.personal.business.dto.MenuTree;
import com.personal.business.entity.BtMenu;
import com.personal.business.mapper.BtMenuMapper;
import com.personal.business.service.IBtMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.personal.business.utils.ZtreeUtils;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author spk
 * @since 2019-07-16
 */
@Service
public class BtMenuServiceImpl extends ServiceImpl<BtMenuMapper, BtMenu> implements IBtMenuService {

    /**
     * @description 根据userId查询用户权限
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public Set<String> getPermsByUserId(Integer userId) {
        List<MenuTree> permsList = getBaseMapper().selectMenusByUserId(userId);
        Set<String> permsSet = new HashSet<>();

        permsList = new ArrayList<>(getParentMenu(permsList,Boolean.TRUE));
        for (MenuTree menuTree : permsList) {
            if (menuTree != null && StringUtils.isNotEmpty(menuTree.getPerms())) {
                permsSet.add(menuTree.getPerms());
            }
        }
        return permsSet;
    }

    @Override
    public List<MenuTree> getUserMenus(Integer userId) {
        List<MenuTree> menus = getBaseMapper().selectMenusByUserId(userId);
        menus = new ArrayList<>(getParentMenu(menus,Boolean.FALSE));
        // set无序，重新排序
        Collections.sort(menus,(z1,z2) -> z1.getOrderNum().compareTo(z2.getOrderNum()));
        return ZtreeUtils.getChildPerms(menus, 0);
    }

    /**
     * @description 获取所有菜单，排序
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public List<BtMenu> getAllMenus() {
        QueryWrapper<BtMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select().orderByAsc(BtMenu::getOrderNum);
        return list(queryWrapper);
    }

    /**
     * @description 删除菜单(如果有子菜单则一并删除)
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public boolean deleteMenus(Integer menuId) {
        UpdateWrapper<BtMenu> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(BtMenu::getMenuId,menuId).or().eq(BtMenu::getParentId,menuId);
        return getBaseMapper().delete(updateWrapper)>0;
    }

    /**
     *        图一                            图二
     *           -----父菜单---                   -----父菜单---√
     *              ---子菜单1---                     ---子菜单1---√
     *              ---子菜单2---√                    ---子菜单2---√
     *              ---子菜单3---√                    ---子菜单3---√
     *              ---子菜单4---√                    ---子菜单4---√
     *
     *         图一和图二两种情况不同，会导致图一不保存父节点id,从而导致树形结构拼装断层，数据缺失
     *         为了规避这个问题,进行一下处理： 循环迭代已有节点，并补齐可能缺失的父节点(Set集合进行去重处理)
     * @author zhangyk
     * @param originList 查出来的可能不全的原始数据
     * @date 2019/5/6 18:48
     */
    private Set<MenuTree> getParentMenu(List<MenuTree> originList,Boolean isAllowF){
        // 中间的父节点set
        Set<Integer> parentIdSet = new HashSet<>();
        // 最终的数据set
        Set<MenuTree> resultSet = new HashSet<>();
        // 使用do - whild 循环 处理 知道parentIdSet没有数据不再迭代
        do{
            parentIdSet = new HashSet<>();
            for (MenuTree menuTree : originList){
/*                if (CommonConstant.MENU_TYPE_M.equalsIgnoreCase(menuTree.getMenuType())){
                    menuTree.setUrl("/" +menuTree.getMenuId());
                }*/
                /*特殊处理 shiro查询菜单(不用权限)和查询权限,查询数据不一样，要特殊处理一下*/
                if (!isAllowF && CommonConstant.MENU_TYPE_F.equalsIgnoreCase(menuTree.getMenuType())){

                }else {
                    resultSet.add(menuTree);
                }
                if (menuTree.getParentId() != null && menuTree.getParentId() != 0){
                    parentIdSet.add(menuTree.getParentId());
                }
            }
            if (parentIdSet.size() > 0){
                originList = getBaseMapper().selectParentMenu(parentIdSet);
            }
        }while(parentIdSet.size() >0);
        return resultSet;
    }

}
