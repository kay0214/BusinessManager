package com.personal.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.personal.business.constant.CommonConstant;
import com.personal.business.dto.SelectorDto;
import com.personal.business.entity.BtCompany;
import com.personal.business.mapper.BtCompanyMapper;
import com.personal.business.request.CompanyRequest;
import com.personal.business.service.IBtCompanyService;
import com.personal.business.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
@Service(value = "company")
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
        queryWrapper.lambda().select().orderByAsc(BtCompany::getSelfId)
                .and(obj->obj.eq(BtCompany::getParentId,0))
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
     * @description 根据selfid获取数据
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public List<BtCompany> getBySelfId(Integer selfId) {
        QueryWrapper<BtCompany> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select().and(obj->obj.eq(BtCompany::getSelfId,selfId));
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
        return getBySelfId(selfId).size()>0;
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
     * @description 根据selfIds获取所有子节点
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public List<BtCompany> getAllChildrenBySelfIds(List<Integer> parentIds) {
        QueryWrapper<BtCompany> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select().and(obj->obj.in(BtCompany::getParentId,parentIds));
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
     * @description 根据creditCode获取所有
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public List<BtCompany> getCompaniesByCreditCode(String creditCode) {
        if(!StringUtils.isEmpty(creditCode)){
            QueryWrapper<BtCompany> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().select().and(obj->obj.eq(BtCompany::getCreditCode,creditCode));
            return list(queryWrapper);
        }
        return new ArrayList<>();
    }

    /**
     * @description 插入数据
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public boolean saveCompany(BtCompany company) {
        // 证件号可以为空，不为空的情况下需要校验是否重复
        if(!StringUtils.isEmpty(company.getCreditCode())){
            // 校验证件号是否重复 - 除非是同一公司
            List<BtCompany> btCompanies = getCompaniesByCreditCode(company.getCreditCode());
            if(!CollectionUtils.isEmpty(btCompanies)){
                if(company.getParentId()!=0){
                    // [] -- [子节点]
                    for (BtCompany exist : btCompanies) {
                        // 父节点 -- 子节点
                        if(exist.getParentId()==0){
                            if(!exist.getSelfId().equals(company.getParentId())){
                                // 插入的并不是exist的子节点，不允许证件号重复
                                log.info("插入的并不是exist的子节点，不允许证件号重复");
                                return false;
                            }
                        }else{
                            // 子节点 -- 子节点
                            if(!exist.getParentId().equals(company.getParentId())){
                                // 插入的并不是exist的兄弟节点，不允许证件号重复
                                log.info("插入的并不是exist的兄弟节点，不允许证件号重复");
                                return false;
                            }
                        }
                    }
                }else{
                    // [] -- [父节点]
                    log.info("插入的父节点与其他节点证件号重复");
                    return false;
                }

            }
        }

        // 如果selfId是空的，那就取
        if(company.getSelfId()==null){
            company.setSelfId(getMaxId());
        }
        if(company.getParentId()!=null && company.getParentId()!=0){
            // 检查是否已经有parentId相同的节点，如果有就不创建
            boolean canRun = getAllChildren(company.getParentId()).size()==0;
            if(canRun){
                List<BtCompany> parents = getBySelfId(company.getParentId());
                if(!CollectionUtils.isEmpty(parents)){
                    BtCompany parent = parents.get(0);
                    // 设立本部
                    BtCompany son = CommonUtils.convertBean(company,BtCompany.class);
                    son.setSelfId(getMaxId());
                    son.setFullName(parent.getFullName() + "-" + CommonConstant.COMPANY_CENTRAL_DEPARTMENT);
                    son.setShortName(CommonConstant.COMPANY_CENTRAL_DEPARTMENT);
                    save(son);
                }

            }

        }
        company.setDelFlag(0);
        company.setCreateTime(company.getCreateTime()==null? LocalDateTime.now():company.getCreateTime());
        company.setUpdateTime(LocalDateTime.now());
        return save(company);
    }

    /**
     * @description 获取所有数据做成下拉框
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public List<SelectorDto> getSelector() {
        List<SelectorDto> result = new ArrayList<>();
        List<BtCompany> companies = list();
        companies.forEach(company -> {
            result.add(new SelectorDto(company.getId(),company.getFullName()));
        });
        return result;
    }
}
