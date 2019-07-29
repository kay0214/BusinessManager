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
}
