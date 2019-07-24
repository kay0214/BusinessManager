package com.personal.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.personal.business.entity.BtUserMenu;
import com.personal.business.mapper.BtUserMenuMapper;
import com.personal.business.request.PermissionsRequest;
import com.personal.business.service.IBtUserMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 用户和菜单关联表 服务实现类
 * </p>
 *
 * @author spk
 * @since 2019-07-16
 */
@Slf4j
@Service
public class BtUserMenuServiceImpl extends ServiceImpl<BtUserMenuMapper, BtUserMenu> implements IBtUserMenuService {

    /**
     * @description 用户授权
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public boolean authorize(PermissionsRequest request) {
        String[] ids = splitString(request.getIds());
        UpdateWrapper<BtUserMenu> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(BtUserMenu::getUserId,request.getUserId()).in(BtUserMenu::getMenuId,ids);
        getBaseMapper().delete(updateWrapper);
        for(String id:ids){
            if(!StringUtils.isEmpty(id)){
                BtUserMenu btUserMenu = new BtUserMenu();
                btUserMenu.setMenuId(Integer.valueOf(id));
                btUserMenu.setUserId(request.getUserId());
                save(btUserMenu);
            }
        }
        return true;
    }

    /**
     * @description 用户取消授权操作
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public boolean unAuthorize(PermissionsRequest request) {
        String[] ids = splitString(request.getIds());
        UpdateWrapper<BtUserMenu> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(BtUserMenu::getUserId,request.getUserId()).in(BtUserMenu::getMenuId,ids);
        return getBaseMapper().delete(updateWrapper)>0;
    }

    /**
     * @description 截取字符串，逗号截取 - lambda要求不能动态变量
     * @auth sunpeikai
     * @param
     * @return
     */
    private String[] splitString(String val){
        return val.split(",");
    }
}
