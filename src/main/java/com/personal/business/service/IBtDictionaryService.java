package com.personal.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.personal.business.entity.BtDictionary;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author spk
 * @since 2019-07-29
 */
public interface IBtDictionaryService extends IService<BtDictionary> {

    /**
     * @description 获取所有字典
     * @auth sunpeikai
     * @param
     * @return
     */
    List<BtDictionary> getAllDictionary();

    /**
     * @description 获取所有子节点
     * @auth sunpeikai
     * @param
     * @return
     */
    List<BtDictionary> getAllChildren(Integer parentId);

    /**
     * @description 根据id去查询字典是否内置
     * @auth sunpeikai
     * @param
     * @return
     */
    boolean isBuiltIn(String ids);

    /**
     * @description 加载所有字典
     * @auth sunpeikai
     * @param
     * @return
     */
    void loadDictionary();

    /**
     * @description 根据id查询名称
     * @auth sunpeikai
     * @param
     * @return
     */
    String getNameById(Integer id);
}
