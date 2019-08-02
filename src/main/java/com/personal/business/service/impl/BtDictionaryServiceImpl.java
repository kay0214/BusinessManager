package com.personal.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.personal.business.constant.CommonConstant;
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
@Service("dictionary")
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
     * @description 根据id去查询字典是否内置
     * @auth sunpeikai
     * @param
     * @return
     */
    @Override
    public boolean isBuiltIn(String ids) {
        String[] id = ids.split(",");
        QueryWrapper<BtDictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select().and(obj->obj.in(BtDictionary::getId,id)).and(obj->obj.eq(BtDictionary::getBuiltIn,CommonConstant.DICTIONARY_BUILD_IN));
        return list(queryWrapper).size()>0;
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
                .and(obj->obj.eq(BtDictionary::getDelFlag, CommonConstant.DEL_FLAG_EXIST));
        List<BtDictionary> all = list(queryWrapper);
        if(!CollectionUtils.isEmpty(all)){
            all.forEach(dictionary -> {
                DictionaryConstant.setDictionary(dictionary.getType(),dictionary.getId(),dictionary.getName(),dictionary.getValue().toString());
            });
            // 处理数据字典数据
            DictionaryConstant.handleDictionary();
        }

    }

    @Override
    public String getNameById(Integer id) {
        log.info("根据id查询name[{}]",id);
        BtDictionary dictionary = getById(id);
        if(dictionary!=null){
            return dictionary.getName();
        }
        return "未知";
    }
}
