/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @author sunpeikai
 * @version RandomUtils, v0.1 2019/7/17 10:33
 * @description
 */
public class RandomUtils {
    private static final int CODEMAXLENGTH = 6;
    public static String getRandomCode(int length) {
        String[] sourceCode = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E",
                "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
                "v", "w", "x", "y", "z" };
        List<String> list = Arrays.asList(sourceCode);
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String afterShuffle = sb.toString();
        String result = afterShuffle.substring(0, length);
        return result;
    }

    public static String getSalt(){
        return getRandomCode(12);
    }

    public static String getValidateCode(){
        String random = "";
        for(int i=0;i<CODEMAXLENGTH;i++){
            random += String.valueOf((int)Math.floor(Math.random() * 9 + 1));
        }
        return random;
    }
    public static String getUuidStr(){
        String uuid = UUID.randomUUID().toString().toUpperCase();
        return uuid.replace("-", "");
    }
}
