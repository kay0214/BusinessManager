package com.personal.business.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.personal.business.entity.BtUser;
import com.personal.business.request.PasswordRequest;
import com.personal.business.request.UserRequest;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author spk
 * @since 2019-07-16
 */
public interface IBtUserService extends IService<BtUser> {

    /**
     * @description 登录操作
     * @auth sunpeikai
     * @param
     * @return
     */
    BtUser login(String username,String password);

    /**
     * @description 分页查询所有用户
     * @auth sunpeikai
     * @param
     * @return
     */
    IPage<BtUser> getAllUsers(UserRequest userRequest);

    /**
     * @description 根据旧密码修改密码
     * @auth sunpeikai
     * @param
     * @return
     */
    boolean modifyPasswordByOld(PasswordRequest request);

}
