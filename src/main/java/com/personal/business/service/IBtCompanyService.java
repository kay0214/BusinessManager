package com.personal.business.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.personal.business.entity.BtCompany;
import com.personal.business.request.CompanyRequest;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author spk
 * @since 2019-07-31
 */
public interface IBtCompanyService extends IService<BtCompany> {

    /**
     * @description 获取未被
     * @auth sunpeikai
     * @param
     * @return
     */
    IPage<BtCompany> getAllCompany(CompanyRequest companyRequest);

    /**
     * @description 获取所有数据
     * @auth sunpeikai
     * @param
     * @return
     */
    List<BtCompany> getAllCompanies();

    /**
     * @description 根据selfid获取数据
     * @auth sunpeikai
     * @param
     * @return
     */
    List<BtCompany> getBySelfId(Integer selfId);

    /**
     * @description 检查selfId是否重复
     * @auth sunpeikai
     * @param
     * @return
     */
    boolean checkExist(Integer selfId);

    /**
     * @description 根据selfId获取所有子节点
     * @auth sunpeikai
     * @param
     * @return
     */
    List<BtCompany> getAllChildren(Integer parentId);

    /**
     * @description 获取自增主键最大值
     * @auth sunpeikai
     * @param
     * @return
     */
    Integer getMaxId();

    /**
     * @description 根据creditCode获取所有
     * @auth sunpeikai
     * @param
     * @return
     */
    List<BtCompany> getCompaniesByCreditCode(String creditCode);

    /**
     * @description 插入数据
     * @auth sunpeikai
     * @param
     * @return
     */
    boolean saveCompany(BtCompany company);
}
