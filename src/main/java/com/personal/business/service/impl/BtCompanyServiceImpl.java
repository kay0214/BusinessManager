package com.personal.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.personal.business.constant.CommonConstant;
import com.personal.business.entity.BtCompany;
import com.personal.business.mapper.BtCompanyMapper;
import com.personal.business.request.CompanyRequest;
import com.personal.business.service.IBtCompanyService;
import com.personal.business.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author spk
 * @since 2019-07-31
 */
@Slf4j
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
        queryWrapper.lambda().select().orderByDesc(BtCompany::getCreateTime)
                .and(!StringUtils.isEmpty(companyRequest.getFullName()),obj->obj.like(BtCompany::getFullName,companyRequest.getFullName()))
                .and(!StringUtils.isEmpty(companyRequest.getCreditCode()),obj->obj.like(BtCompany::getCreditCode,companyRequest.getCreditCode()))
                .and(!StringUtils.isEmpty(companyRequest.getCompanyCode()),obj->obj.like(BtCompany::getCompanyCode,companyRequest.getCompanyCode()))
                .and(companyRequest.getType()!=null,obj->obj.eq(BtCompany::getType,companyRequest.getType()))
                .and(companyRequest.getStatus()!=null,obj->obj.eq(BtCompany::getStatus,companyRequest.getStatus()));
        return page(new Page<>(companyRequest.getPage(),companyRequest.getLimit()),queryWrapper);
    }

    /**
     * @description 获取所有数据
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public List<BtCompany> getAllCompanies() {
        QueryWrapper<BtCompany> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select().orderByAsc(BtCompany::getSelfId);
        return list(queryWrapper);
    }

    /**
     * @description 检查selfId是否重复
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public boolean checkExist(Integer selfId) {
        QueryWrapper<BtCompany> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select().and(obj->obj.eq(BtCompany::getSelfId,selfId));
        return list(queryWrapper).size()>0;
    }

    /**
     * @description 根据selfId获取所有子节点
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public List<BtCompany> getAllChildren(Integer parentId) {
        QueryWrapper<BtCompany> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select().and(obj->obj.eq(BtCompany::getParentId,parentId));
        return list(queryWrapper);
    }

    /**
     * @description 获取自增主键最大值
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public Integer getMaxId(){
        Integer max = getBaseMapper().getMaxId();
        boolean enable;
        do {
            max ++ ;
            enable = checkExist(max);
        }while (enable);
        return max;
    }

    /**
     * @description 插入数据
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public boolean saveCompany(BtCompany company) {
        // 如果selfId是空的，那就取
        if(company.getSelfId()==null){
            company.setSelfId(getMaxId());
        }
        if(company.getParentId()!=null && company.getParentId()!=0){
            // 检查是否已经有parentId相同的节点，如果有就不创建
            boolean canRun = getAllChildren(company.getParentId()).size()==0;
            if(canRun){
                // 设立本部
                BtCompany son = CommonUtils.convertBean(company,BtCompany.class);
                son.setSelfId(getMaxId());
                son.setFullName(CommonConstant.COMPANY_CENTRAL_DEPARTMENT);
                son.setShortName(CommonConstant.COMPANY_CENTRAL_DEPARTMENT);
                save(son);
            }

        }
        company.setDelFlag(0);
        company.setCreateTime(company.getCreateTime()==null? LocalDateTime.now():company.getCreateTime());
        company.setUpdateTime(LocalDateTime.now());
        return save(company);
    }
}
