package com.personal.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.personal.business.entity.BtInOutGeneral;
import com.personal.business.mapper.BtInOutGeneralMapper;
import com.personal.business.request.InOutGeneralRequest;
import com.personal.business.service.IBtInOutGeneralService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author spk
 * @since 2019-09-08
 */
@Service
public class BtInOutGeneralServiceImpl extends ServiceImpl<BtInOutGeneralMapper, BtInOutGeneral> implements IBtInOutGeneralService {

    /**
     * 获取列表
     * */
    @Override
    public IPage<BtInOutGeneral> getAllGeneral(InOutGeneralRequest request) {
        QueryWrapper<BtInOutGeneral> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select().orderByDesc(BtInOutGeneral::getCreateTime)
                .and(StringUtils.isNotBlank(request.getMapCode()),obj->obj.eq(BtInOutGeneral::getMapCode,request.getMapCode()))
                .and(StringUtils.isNotBlank(request.getInOutNo()),obj->obj.eq(BtInOutGeneral::getInOutNo,request.getInOutNo()))
                .and(request.getInOut()!=null,obj->obj.eq(BtInOutGeneral::getInOut,request.getInOut()))
                .and(request.getInOutType()!=null,obj->obj.eq(BtInOutGeneral::getInOutType,request.getInOutType()))
                .and(request.getCompanyId()!=null,obj->obj.eq(BtInOutGeneral::getCompanyId,request.getCompanyId()));
        return page(new Page<>(request.getPage(),request.getLimit()),queryWrapper);
    }
}
