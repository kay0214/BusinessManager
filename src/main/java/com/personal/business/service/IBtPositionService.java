package com.personal.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.personal.business.entity.BtPosition;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author spk
 * @since 2019-08-05
 */
public interface IBtPositionService extends IService<BtPosition> {

    /**
     * @description 获取所有职位信息
     * @auth sunpeikai
     * @param
     * @return
     */
    List<BtPosition> getAllPositions();
}
