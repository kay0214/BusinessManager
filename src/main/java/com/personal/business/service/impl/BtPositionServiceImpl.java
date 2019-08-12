package com.personal.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.personal.business.entity.BtPosition;
import com.personal.business.mapper.BtPositionMapper;
import com.personal.business.service.IBtPositionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author spk
 * @since 2019-08-05
 */
@Service
public class BtPositionServiceImpl extends ServiceImpl<BtPositionMapper, BtPosition> implements IBtPositionService {

    /**
     * @description 获取所有职位信息
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public List<BtPosition> getAllPositions() {
        QueryWrapper<BtPosition> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select().orderByAsc(BtPosition::getOrderNum);
        return list(queryWrapper);
    }
}
