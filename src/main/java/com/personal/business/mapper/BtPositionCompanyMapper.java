package com.personal.business.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.personal.business.dto.StaffDto;
import com.personal.business.entity.BtPositionCompany;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author spk
 * @since 2019-08-08
 */
public interface BtPositionCompanyMapper extends BaseMapper<BtPositionCompany> {

    /**
     * @description 根据岗位id获取员工信息
     * @auth sunpeikai
     * @param
     * @return
     */
    IPage<StaffDto> getStaffByPositionId(@Param("iPage") IPage<Object> iPage, @Param("positionId") Integer positionId);

    /**
     * @description 根据岗位id获取全部员工信息
     * @auth sunpeikai
     * @param
     * @return
     */
    List<StaffDto> getStaffsByPositionId(@Param("positionId") Integer positionId);

    /**
     * @description 根据岗位id获取全部员工信息
     * @auth sunpeikai
     * @param
     * @return
     */
    List<StaffDto> getStaffsNotInPosition(@Param("positionId") Integer positionId,@Param("type") Integer type);
}
