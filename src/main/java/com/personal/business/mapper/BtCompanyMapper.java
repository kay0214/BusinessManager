package com.personal.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.personal.business.entity.BtCompany;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author spk
 * @since 2019-07-31
 */
public interface BtCompanyMapper extends BaseMapper<BtCompany> {

    /**
     * @description 获取自增主键最大值
     * @auth sunpeikai
     * @param
     * @return
     */
    Integer getMaxId();
}
