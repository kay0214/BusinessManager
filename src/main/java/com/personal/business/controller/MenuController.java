/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.controller;

import com.alibaba.fastjson.JSON;
import com.personal.business.enums.ResultEnum;
import com.personal.business.base.BaseController;
import com.personal.business.base.Return;
import com.personal.business.constant.CommonConstant;
import com.personal.business.constant.ShiroPermissionsConstant;
import com.personal.business.dto.MenuTreeDto;
import com.personal.business.dto.MenuTree;
import com.personal.business.entity.BtMenu;
import com.personal.business.entity.BtUser;
import com.personal.business.service.IBtMenuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunpeikai
 * @version MenuController, v0.1 2019/7/17 10:15
 * @description
 */
@Slf4j
@Controller
@RequestMapping(value = "/system/menu")
public class MenuController extends BaseController {

    @Autowired
    private IBtMenuService iBtMenuService;

    /**
     * @description 进入菜单管理视图
     * @auth sunpeikai
     * @param
     * @return
     */
    @GetMapping(value = "/init")
    public String init(){
        return "iframe/menuManager";
    }

    /**
     * @description 根据登录用户id获取所有菜单
     * @auth sunpeikai
     * @param
     * @return
     */
    @GetMapping(value = "/getMenus")
    @ResponseBody
    public Return getMenus(){
        Integer userId = getCurrentUserId();
        log.info("get user menus , userId:[{}]",userId);
        return Return.data(iBtMenuService.getUserMenus(userId));
    }

    /**
     * @description 获取所有菜单
     * @auth sunpeikai
     * @param
     * @return
     */
    @RequiresPermissions(ShiroPermissionsConstant.PERM_MENU_LIST)
    @GetMapping(value = "/getAllMenus")
    @ResponseBody
    public Return getAllMenus(){
        log.info("get all menus");
        return Return.data(iBtMenuService.getAllMenus());
    }

    /**
     * @description 更新菜单
     * @auth sunpeikai
     * @param
     * @return
     */
    @RequiresPermissions(ShiroPermissionsConstant.PERM_MENU_EDIT)
    @PostMapping(value = "/update")
    @ResponseBody
    public Return update(@RequestBody BtMenu menu){
        log.info(JSON.toJSONString(menu));
        boolean success = iBtMenuService.updateById(menu);
        if(success){
            return Return.success();
        }else{
            return Return.fail("更新失败");
        }
    }

    /**
     * @description 删除菜单
     * @auth sunpeikai
     * @param
     * @return
     */
    @RequiresPermissions(ShiroPermissionsConstant.PERM_MENU_DEL)
    @GetMapping(value = "/delete/{menuId}")
    @ResponseBody
    public Return delete(@PathVariable Integer menuId){
        log.info("delete menu [{}]",menuId);
        boolean success = iBtMenuService.deleteMenus(menuId);
        if(success){
            return Return.success();
        }else{
            return Return.fail("删除失败");
        }
    }

    /**
     * @description 插入菜单
     * @auth sunpeikai
     * @param
     * @return
     */
    @RequiresPermissions(ShiroPermissionsConstant.PERM_MENU_ADD)
    @PostMapping(value = "/insert")
    @ResponseBody
    public Return insert(@RequestBody BtMenu menu){
        log.info("insert menu [{}]",JSON.toJSONString(menu));
        BtUser user = getCurrentUser();
        menu.setUrl(StringUtils.isEmpty(menu.getUrl())? CommonConstant.MENU_INSERT_DEFAULT_VALUE :menu.getUrl());
        menu.setPerms(StringUtils.isEmpty(menu.getPerms())?CommonConstant.MENU_INSERT_DEFAULT_VALUE:menu.getPerms());
        menu.setIcon(StringUtils.isEmpty(menu.getIcon())?CommonConstant.MENU_INSERT_DEFAULT_VALUE:menu.getIcon());
        menu.setDelFlag(0);
        menu.setCreateBy(user.getUserName());
        menu.setCreateTime(LocalDateTime.now());
        menu.setUpdateBy(user.getUserName());
        menu.setUpdateTime(LocalDateTime.now());
        boolean success = iBtMenuService.save(menu);
        if(success){
            return Return.success();
        }else{
            return Return.fail("添加失败");
        }
    }

    /**
     * @description 获取用户未授权菜单 - 菜单授权
     * @auth sunpeikai
     * @param
     * @return
     */
    @GetMapping(value = "/getUnAuthorizeMenus/{userId}")
    @ResponseBody
    public Return<List<MenuTreeDto>> getUnAuthorizeMenus(@PathVariable Integer userId){
        if(userId!=null){
            List<MenuTree> menus = iBtMenuService.getUnAuthorizeMenus(userId);
            return Return.data(getMenuTreeSelector(menus));
        }
        return Return.fail(ResultEnum.ERROR_PARAM_NOT_ENOUGH);
    }

    /**
     * @description 取消用户已授权菜单 - 取消授权
     * @auth sunpeikai
     * @param
     * @return
     */
    @GetMapping(value = "/getAuthorizeMenus/{userId}")
    @ResponseBody
    public Return<List<MenuTreeDto>> getAuthorizeMenus(@PathVariable Integer userId){
        if(userId!=null){
            List<MenuTree> menus = iBtMenuService.getAuthorizeMenus(userId);
            return Return.data(getMenuTreeSelector(menus));
        }
        return Return.fail(ResultEnum.ERROR_PARAM_NOT_ENOUGH);
    }

    @GetMapping(value = "/getById/{menuId}")
    @ResponseBody
    public Return getById(@PathVariable Integer menuId){
        log.info("get menu by id[{}]",menuId);
        return Return.data(iBtMenuService.getById(menuId));
    }

    /**
     * @description 数据处理
     * @auth sunpeikai
     * @param
     * @return
     */
    private List<MenuTreeDto> getMenuTreeSelector(List<MenuTree> menus){
        List<MenuTreeDto> result = new ArrayList<>();
        if(menus!=null && menus.size()>0){
            for(MenuTree one:menus){
                MenuTreeDto levelOne = new MenuTreeDto();
                levelOne.setId(one.getMenuId());
                levelOne.setLabel(one.getMenuName());
                if(one.getChildren()!=null && one.getChildren().size()>0){
                    for(MenuTree two:one.getChildren()){
                        MenuTreeDto levelTwo = new MenuTreeDto();
                        levelTwo.setId(two.getMenuId());
                        levelTwo.setLabel(two.getMenuName());
                        if(two.getChildren()!=null && two.getChildren().size()>0){
                            for(MenuTree three:two.getChildren()){
                                MenuTreeDto levelThree = new MenuTreeDto();
                                levelThree.setId(three.getMenuId());
                                levelThree.setLabel(three.getMenuName());
                                levelTwo.getChildren().add(levelThree);
                            }
                        }
                        levelOne.getChildren().add(levelTwo);
                    }
                }
                result.add(levelOne);
            }
        }
        return result;
    }
}
