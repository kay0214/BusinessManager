package com.personal.business.utils;

import com.personal.business.dto.MenuTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author zhangyk
 * @date 2019/4/4 11:47
 */
public class ZtreeUtils {


    /**
     * 根据父节点的ID获取所有子节点
     *
     * @param list     分类表
     * @param parentId 传入的父节点ID
     * @return String
     */
    public static List<MenuTree> getChildPerms(List<MenuTree> list, int parentId) {
        List<MenuTree> returnList = new ArrayList<>();
        for (Iterator<MenuTree> iterator = list.iterator(); iterator.hasNext(); ) {
            MenuTree t =  iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (t.getParentId() == parentId) {
                recursionFn(list, t);
                returnList.add(t);
            }
        }
        return returnList;
    }

    /**
     * 递归列表
     *
     * @param list
     * @param t
     */
    private static void recursionFn(List<MenuTree> list, MenuTree t) {
        // 得到子节点列表
        List<MenuTree> childList = getChildList(list, t);
        t.setChildren(childList);
        for (MenuTree tChild : childList) {
            if (hasChild(list, tChild)) {
                // 判断是否有子节点
                Iterator<MenuTree> it = childList.iterator();
                while (it.hasNext()) {
                    MenuTree n =  it.next();
                    recursionFn(list, n);
                }
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private static List<MenuTree> getChildList(List<MenuTree> list, MenuTree t) {
        List<MenuTree> tlist = new ArrayList<>();
        Iterator<MenuTree> it = list.iterator();
        while (it.hasNext()) {
            MenuTree n =  it.next();
            if (n.getParentId().longValue() == t.getMenuId().longValue()) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private static boolean hasChild(List<MenuTree> list, MenuTree t) {
        return getChildList(list, t).size() > 0 ? true : false;
    }
}
