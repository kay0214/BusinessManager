package com.personal.business.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.personal.business.dto.StaffDto;
import com.personal.business.entity.BtPositionCompany;
import com.baomidou.mybatisplus.extension.service.IService;
import com.personal.business.request.StaffRequest;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author spk
 * @since 2019-08-08
 */
public interface IBtPositionCompanyService extends IService<BtPositionCompany> {

    /**
     * @description 根据岗位id获取员工信息
     * @auth sunpeikai
     * @param
     * @return
     */
    IPage<StaffDto> getStaffByPositionId(StaffRequest request);
}
