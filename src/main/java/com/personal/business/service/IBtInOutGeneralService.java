package com.personal.business.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.personal.business.entity.BtInOutGeneral;
import com.baomidou.mybatisplus.extension.service.IService;
import com.personal.business.request.InOutGeneralRequest;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author spk
 * @since 2019-09-08
 */
public interface IBtInOutGeneralService extends IService<BtInOutGeneral> {

    /**
     * 获取列表
     * */
    IPage<BtInOutGeneral> getAllGeneral(InOutGeneralRequest request);
}
