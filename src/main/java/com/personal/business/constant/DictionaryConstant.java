/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.constant;

import com.personal.business.dto.SelectorDto;

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
    private static Map<String, List<SelectorDto>> selectors = new HashMap<>();

    public static void setDictionary(String type,Integer key,String value){
        List<SelectorDto> selectorDtos = new ArrayList<>();
        if(selectors.containsKey(type)){
            selectorDtos = getDictionary(type);
        }
        SelectorDto selectorDto = new SelectorDto();
        selectorDto.setKey(key);
        selectorDto.setValue(value);
        selectorDtos.add(selectorDto);
        selectors.put(type,selectorDtos);
    }

    public static List<SelectorDto> getDictionary(String type){
        List<SelectorDto> result = new ArrayList<>();
        if(selectors.containsKey(type)){
            result = selectors.get(type);
        }
        return result;
    }

    public static void clearDictionary(){
        if(selectors!=null && selectors.size()>0){
            selectors.clear();
        }
    }
}
