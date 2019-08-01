package com.personal.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.personal.business.constant.DictionaryConstant;
import com.personal.business.entity.BtDictionary;
import com.personal.business.mapper.BtDictionaryMapper;
import com.personal.business.service.IBtDictionaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author spk
 * @since 2019-07-29
 */
@Slf4j
@Service
public class BtDictionaryServiceImpl extends ServiceImpl<BtDictionaryMapper, BtDictionary> implements IBtDictionaryService {

    /**
     * @description 获取所有字典
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public List<BtDictionary> getAllDictionary() {
        QueryWrapper<BtDictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select().orderByAsc(BtDictionary::getOrderNum);
        return list(queryWrapper);
    }

    /**
     * @description 获取所有子节点
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public List<BtDictionary> getAllChildren(Integer parentId) {
        QueryWrapper<BtDictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select().orderByAsc(BtDictionary::getOrderNum).and(obj->obj.eq(BtDictionary::getParentId,parentId));
        return list(queryWrapper);
    }

    /**
     * @description 加载所有字典
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public void loadDictionary() {
        // 清空原有字典
        DictionaryConstant.clearDictionary();
        QueryWrapper<BtDictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select().orderByAsc(BtDictionary::getOrderNum)
                .and(obj->obj.eq(BtDictionary::getFreeze,0))
                .and(obj->obj.eq(BtDictionary::getDelFlag,0));
        List<BtDictionary> all = list(queryWrapper);
        if(!CollectionUtils.isEmpty(all)){
            all.forEach(dictionary -> {
                DictionaryConstant.setDictionary(dictionary.getType(),dictionary.getId(),dictionary.getName());
            });
        }

    }
}
