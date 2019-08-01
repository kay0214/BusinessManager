package com.personal.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.personal.business.constant.CommonConstant;
import com.personal.business.entity.BtCompany;
import com.personal.business.mapper.BtCompanyMapper;
import com.personal.business.request.CompanyRequest;
import com.personal.business.service.IBtCompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author spk
 * @since 2019-07-31
 */
@Service
public class BtCompanyServiceImpl extends ServiceImpl<BtCompanyMapper, BtCompany> implements IBtCompanyService {

    /**
     * @description 获取未被
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public IPage<BtCompany> getAllCompany(CompanyRequest companyRequest) {
        QueryWrapper<BtCompany> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select().orderByDesc(BtCompany::getCreateTime);
        return page(new Page<>(companyRequest.getPage(),companyRequest.getLimit()),queryWrapper);
    }
}
