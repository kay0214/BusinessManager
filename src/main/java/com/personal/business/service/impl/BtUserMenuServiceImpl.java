package com.personal.business.service.impl;

import com.personal.business.entity.BtUserMenu;
import com.personal.business.mapper.BtUserMenuMapper;
import com.personal.business.service.IBtUserMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和菜单关联表 服务实现类
 * </p>
 *
 * @author spk
 * @since 2019-07-16
 */
@Service
public class BtUserMenuServiceImpl extends ServiceImpl<BtUserMenuMapper, BtUserMenu> implements IBtUserMenuService {

}
