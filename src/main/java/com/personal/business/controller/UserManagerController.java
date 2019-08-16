/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.personal.business.base.BaseController;
import com.personal.business.base.Return;
import com.personal.business.config.SystemConfig;
import com.personal.business.constant.CommonConstant;
import com.personal.business.constant.ShiroPermissionsConstant;
import com.personal.business.dto.UserDto;
import com.personal.business.entity.BtUser;
import com.personal.business.enums.ResultEnum;
import com.personal.business.request.UserRequest;
import com.personal.business.service.IBtUserService;
import com.personal.business.utils.CommonUtils;
import com.personal.business.utils.Md5Utils;
import com.personal.business.utils.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sunpeikai
 * @version UserManagerController, v0.1 2019/7/22 14:53
 * @description
 */
@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserManagerController extends BaseController {

    @Autowired
    private IBtUserService iBtUserService;
    @Autowired
    private SystemConfig systemConfig;

    /**
     * @description 进入用户管理视图
     * @auth sunpeikai
     * @param
     * @return
     */
    @GetMapping(value = "/init")
    public String init(){
        return "iframe/userManager";
    }

    /**
     * @description 用户管理 - 数据表格分页查询
     * @auth sunpeikai
     * @param
     * @return
     */
    @RequiresPermissions(ShiroPermissionsConstant.PERM_USER_LIST)
    @PostMapping(value = "/searchList")
    @ResponseBody
    public Return searchList(@RequestBody UserRequest userRequest){
        log.info("search user[{}]", JSON.toJSONString(userRequest));
        IPage<BtUser> users = iBtUserService.getAllUsers(userRequest);
        // 实体转换
        IPage<UserDto> result = users.convert(btUser -> {
            UserDto userDto = CommonUtils.convertBean(btUser,UserDto.class);
            // 数据脱敏是否需要做
/*            userDto.setEmail(DataMaskUtils.email(userDto.getEmail()));
            userDto.setMobile(DataMaskUtils.mobile(userDto.getMobile()));*/
            return userDto;
        });
        return Return.data(result);
    }

    /**
     * @description 更新用户
     * @auth sunpeikai
     * @param
     * @return
     */
    @RequiresPermissions(ShiroPermissionsConstant.PERM_USER_EDIT)
    @PostMapping(value = "/update")
    @ResponseBody
    public Return update(@RequestBody BtUser user){
        log.info(JSON.toJSONString(user));
        boolean success = iBtUserService.updateById(user);
        if(success){
            return Return.success();
        }else{
            return Return.fail("更新失败");
        }
    }

    /**
     * @description 新增用户
     * @auth sunpeikai
     * @param
     * @return
     */
    @RequiresPermissions(ShiroPermissionsConstant.PERM_USER_ADD)
    @PostMapping(value = "/insert")
    @ResponseBody
    public Return insert(@RequestBody BtUser user){
        if(user.getUserName().length()<CommonConstant.USERNAME_MIN_LENGTH || user.getUserName().length()>CommonConstant.USERNAME_MAX_LENGTH){
            return Return.fail(ResultEnum.ERROR_USERNAME_LENGTH);
        }
        user.setSalt(RandomUtils.getSalt());
        String password = RandomUtils.getPassword();
        // 默认密码启用 - 则设置默认密码
        if(systemConfig.isDefaultPasswordEnabled()){
            password = systemConfig.getDefaultPassword();
        }
        String passwordEncrypt = Md5Utils.encryptPassword(user.getUserName(),password,user.getSalt());
        user.setPassword(passwordEncrypt);
        user.setUserType(CommonConstant.USER_TYPE_SYSTEM);
        user.setAvatar(systemConfig.getAvatar());
        user.setDelFlag(CommonConstant.DEL_FLAG_EXIST);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        boolean success = iBtUserService.save(user);
        if(success){
            return Return.success();
        }else{
            return Return.fail("更新失败");
        }
    }

    /**
     * @description 删除用户
     * @auth sunpeikai
     * @param
     * @return
     */
    @RequiresPermissions(ShiroPermissionsConstant.PERM_USER_DEL)
    @GetMapping(value = "/delete/{ids}")
    @ResponseBody
    public Return delete(@PathVariable String ids){
        if(!StringUtils.isEmpty(ids)){
            List<String> idsArray = new ArrayList<>();
            Collections.addAll(idsArray, ids.split(","));
            boolean success = iBtUserService.removeByIds(idsArray);
            if(success){
                return Return.success();
            }else{
                return Return.fail("删除失败");
            }
        }
        return Return.fail(ResultEnum.ERROR_PARAM_NOT_ENOUGH);
    }

    /**
     * @description 重置密码
     * @auth sunpeikai
     * @param
     * @return
     */
    @RequiresPermissions(ShiroPermissionsConstant.PERM_USER_EDIT)
    @GetMapping(value = "/password/reset/{userId}")
    @ResponseBody
    public Return reset(@PathVariable Integer userId){
        if(userId!=null){
            log.info(JSON.toJSONString(userId));
            BtUser user = iBtUserService.getById(userId);
            user.setSalt(RandomUtils.getSalt());
            String password = RandomUtils.getPassword();
            // 默认密码启用 - 则设置默认密码
            if(systemConfig.isDefaultPasswordEnabled()){
                password = systemConfig.getDefaultPassword();
                log.info("modify password [{}]",password);
            }
            String passwordEncrypt = Md5Utils.encryptPassword(user.getUserName(),password,user.getSalt());
            user.setPassword(passwordEncrypt);
            user.setUpdateTime(LocalDateTime.now());
            boolean success = iBtUserService.updateById(user);
            if(success){
                return Return.success();
            }else{
                return Return.fail("更新失败");
            }
        }
        return Return.fail("用户ID不能为空");
    }
}
