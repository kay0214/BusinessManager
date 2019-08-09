package com.personal.business.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.personal.business.constant.CommonConstant;
import com.personal.business.constant.DictionaryConstant;
import com.personal.business.dto.SelectorDto;
import com.personal.business.dto.StaffDto;
import com.personal.business.entity.BtPositionCompany;
import com.personal.business.mapper.BtPositionCompanyMapper;
import com.personal.business.request.StaffRequest;
import com.personal.business.service.IBtPositionCompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service("staff")
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

    /**
     * @description 根据岗位id获取全部员工信息
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public List<StaffDto> getStaffsByPositionId(Integer positionId) {
        return positionCompanyMapper.getStaffsByPositionId(positionId);
    }

    /**
     * @description 获取所有未在这个岗位的岗位人员
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public List<StaffDto> getStaffsNotInPosition(Integer positionId) {
        SelectorDto selectorDto = DictionaryConstant.getDictionary(CommonConstant.DICTIONARY_RELATIONSHIP,CommonConstant.DICTIONARY_RELATIONSHIP_STAFF);
        return positionCompanyMapper.getStaffsNotInPosition(positionId,selectorDto.getKey());
    }
}
