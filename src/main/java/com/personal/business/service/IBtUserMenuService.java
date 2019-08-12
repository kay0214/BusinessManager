package com.personal.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.personal.business.entity.BtUserMenu;
import com.personal.business.request.PermissionsRequest;

/**
 * <p>
 * 用户和菜单关联表 服务类
 * </p>
 *
 * @author spk
 * @since 2019-07-16
 */
public interface IBtUserMenuService extends IService<BtUserMenu> {

    /**
     * @description 用户授权
     * @auth sunpeikai
     * @param
     * @return
     */
    boolean authorize(PermissionsRequest request);

    /**
     * @description 用户取消授权操作
     * @auth sunpeikai
     * @param
     * @return
     */
    boolean unAuthorize(PermissionsRequest request);
}
