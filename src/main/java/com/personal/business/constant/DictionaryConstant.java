/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.constant;

import com.personal.business.dto.SelectorDto;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunpeikai
 * @version DictionaryConstant, v0.1 2019/7/31 14:38
 * @description
 */
public class DictionaryConstant {
    private static Map<String, Map<String,Object>> selectors = new HashMap<>();

    public static void setDictionary(String type,Integer key,String name,String value){
        Map<String,Object> selectorDtoMap = new HashMap<>();
        if(selectors.containsKey(type)){
            selectorDtoMap = selectors.get(type);
        }
        SelectorDto selectorDto = new SelectorDto();
        selectorDto.setKey(key);
        selectorDto.setValue(name);
        selectorDtoMap.put(value,selectorDto);
        selectors.put(type,selectorDtoMap);
    }

    public static void handleDictionary(){
        if(selectors!=null && selectors.size()>0){
            selectors.forEach((key,object)->{
                if(object!=null){
                    Map<String,Object> nodes = new HashMap<>();
                    List<SelectorDto> selectorDtos = new ArrayList<>();
                    ((Map<String,Object>)object).forEach((key1, selector)->{
                        SelectorDto selectorDto = (SelectorDto)selector;
                        selectorDtos.add(new SelectorDto(selectorDto.getKey(),selectorDto.getValue()));
                    });
                    // 组装起来的元素
                    nodes.put(CommonConstant.DICTIONARY_ALL,selectorDtos);
                    // 所有单个元素
                    nodes.putAll((Map<String,Object>)object);
                    // 所有节点
                    selectors.put(key,nodes);
                }
            });
        }
    }

    public static SelectorDto getDictionary(String type,String key){
        SelectorDto result = new SelectorDto();
        if(selectors.containsKey(type)){
            Map<String,Object> map = selectors.get(type);
            if(!CollectionUtils.isEmpty(map) && map.containsKey(key)){
                result = (SelectorDto)map.get(key);
            }
        }
        return result;
    }

    public static List<SelectorDto> getDictionaries(String type){
        List<SelectorDto> result = new ArrayList<>();
        if(selectors.containsKey(type)){
            Map<String,Object> map = selectors.get(type);
            if(!CollectionUtils.isEmpty(map) && map.containsKey(CommonConstant.DICTIONARY_ALL)){
                result = (List<SelectorDto>)map.get(CommonConstant.DICTIONARY_ALL);
            }
        }
        return result;
    }

    public static void clearDictionary(){
        if(selectors!=null && selectors.size()>0){
            selectors.clear();
        }
    }
}
