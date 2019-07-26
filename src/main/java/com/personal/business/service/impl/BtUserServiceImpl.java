package com.personal.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.personal.business.Enum.ResultEnum;
import com.personal.business.config.thymeleaf.ShiroPermissionsUtils;
import com.personal.business.constant.CommonConstant;
import com.personal.business.entity.BtUser;
import com.personal.business.exception.LoginException;
import com.personal.business.mapper.BtUserMapper;
import com.personal.business.request.PasswordRequest;
import com.personal.business.request.UserRequest;
import com.personal.business.service.IBtUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.personal.business.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author spk
 * @since 2019-07-16
 */
@Slf4j
@Service
public class BtUserServiceImpl extends ServiceImpl<BtUserMapper, BtUser> implements IBtUserService {

    /**
     * @description 登录操作
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public BtUser login(String username, String password) {
        // 验证码校验
        if (!StringUtils.isEmpty(SessionUtils.getHttpServletRequest().getAttribute(CommonConstant.CURRENT_CAPTCHA))) {
            throw new LoginException(ResultEnum.ERROR_VALIDATECODE);
        }
        // 用户名或密码为空 错误
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new LoginException(ResultEnum.ERROR_USERNAME_OR_PASSWORD);
        }

        // 用户名不在指定范围内 错误
        if (username.length() < CommonConstant.USERNAME_MIN_LENGTH
                || username.length() > CommonConstant.USERNAME_MAX_LENGTH) {
            throw new LoginException(ResultEnum.ERROR_USERNAME_LENGTH);
        }

        // 查询用户信息
        BtUser user = getOne(new QueryWrapper<BtUser>().setEntity(new BtUser().setUserName(username).setStatus(0).setDelFlag(0)));

        if (user == null && LoginUtils.maybeMobile(username)) {
            user = getOne(new QueryWrapper<BtUser>().setEntity(new BtUser().setMobile(username).setStatus(0).setDelFlag(0)));
        }

        if (user == null && LoginUtils.maybeEmail(username)) {
            user = getOne(new QueryWrapper<BtUser>().setEntity(new BtUser().setEmail(username).setStatus(0).setDelFlag(0)));
        }

        if (user == null) {
            throw new LoginException(ResultEnum.ERROR_USER_EXIST);
        }
        // 校验密码
        String passwordEncrypt = Md5Utils.encryptPassword(user.getUserName(),password,user.getSalt());
        if(!passwordEncrypt.equals(user.getPassword())){
            log.info(">>>>>用户名密码验证不通过:username[{}],password[{}]<<<<<",user.getUserName(),password);
            throw new LoginException(ResultEnum.ERROR_USERNAME_OR_PASSWORD);
        }
        user.setLoginIp(SessionUtils.getIp());
        user.setLoginDate(LocalDateTime.now());
        // 更新登录信息
        updateById(user);
        // 触发权限缓存
        ShiroPermissionsUtils.trigger();
        // 放到session
        SessionUtils.setSessionAttribute("user",user);
        return user;
    }

    /**
     * @description 分页查询所有用户
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public IPage<BtUser> getAllUsers(UserRequest userRequest) {
        QueryWrapper<BtUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select().orderByDesc(BtUser::getCreateTime)
                .and(!StringUtils.isEmpty(userRequest.getUsername()),obj->obj.like(BtUser::getUserName,userRequest.getUsername()))
                .and(!StringUtils.isEmpty(userRequest.getMobile()),obj->obj.like(BtUser::getMobile,userRequest.getMobile()))
                .and(!StringUtils.isEmpty(userRequest.getEmail()),obj->obj.like(BtUser::getEmail,userRequest.getEmail()))
                .and(userRequest.getStatus()!=null,obj->obj.eq(BtUser::getStatus,userRequest.getStatus()));
        return page(new Page<>(userRequest.getPage(),userRequest.getLimit()),queryWrapper);
    }

    /**
     * @description 根据旧密码修改密码
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public boolean modifyPasswordByOld(PasswordRequest request) {
        BtUser user = getById(request.getUserId());
        if (user == null) {
            throw new LoginException(ResultEnum.ERROR_USER_EXIST);
        }
        // 校验密码
        String passwordEncrypt = Md5Utils.encryptPassword(user.getUserName(),request.getOldPassword(),user.getSalt());
        if(!passwordEncrypt.equals(user.getPassword())){
            log.info(">>>>>密码验证不通过:username[{}],password[{}]<<<<<",user.getUserName(),request.getOldPassword());
            throw new LoginException(ResultEnum.ERROR_PASSWORD);
        }
        // 验证通过
        user.setSalt(RandomUtils.getSalt());
        String newPasswordEncrypt = Md5Utils.encryptPassword(user.getUserName(),request.getPassword(),user.getSalt());
        user.setPassword(newPasswordEncrypt);
        user.setUpdateTime(LocalDateTime.now());
        return updateById(user);
    }
}
