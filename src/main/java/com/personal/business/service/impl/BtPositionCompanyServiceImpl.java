package com.personal.business.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.personal.business.dto.StaffDto;
import com.personal.business.entity.BtPositionCompany;
import com.personal.business.mapper.BtPositionCompanyMapper;
import com.personal.business.request.StaffRequest;
import com.personal.business.service.IBtPositionCompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author spk
 * @since 2019-08-08
 */
@Service
public class BtPositionCompanyServiceImpl extends ServiceImpl<BtPositionCompanyMapper, BtPositionCompany> implements IBtPositionCompanyService {

    @Autowired
    private BtPositionCompanyMapper positionCompanyMapper;

    /**
     * @description 根据岗位id获取员工信息
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public IPage<StaffDto> getStaffByPositionId(StaffRequest request) {
        return positionCompanyMapper.getStaffByPositionId(new Page<>(request.getPage(),request.getLimit()),request.getPositionId());
    }
}
