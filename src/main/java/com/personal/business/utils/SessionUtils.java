/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.utils;

import com.personal.business.entity.BtUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author sunpeikai
 * @version SessionUtils, v0.1 2019/7/17 20:37
 * @description
 */
@Slf4j
public class SessionUtils {

    public static Integer getUserId(){
        BtUser user = getUser();
        if(user != null){
            return user.getUserId();
        }
        return null;
    }

    public static BtUser getUser(){
        BtUser user = null;
        try{
            user = (BtUser)getSessionAttribute("user");
        }catch (Exception e){
            log.error("从session中获取用户信息失败!");
        }
        return user;
    }

    /**
     * @description 获取登录用户ip
     * @auth sunpeikai
     * @param
     * @return
     */
    public static String getIp(){
        HttpServletRequest request = getHttpServletRequest();
        if (request == null) {
            return "unknown";
        }
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

    /**
     * @description 删除session值
     * @auth sunpeikai
     * @param
     * @return
     */
    public static void removeSessionAttribute(String key){
        getSession().removeAttribute(key);
    }

    /**
     * 往session里面设置值
     * @auth sunpeikai
     * @param
     * @return
     */
    public static void setSessionAttribute(String key,Object value){
        getSession().setAttribute(key, value);
    }

    /**
     * 从session中取值
     * @auth sunpeikai
     * @param
     * @return
     */
    public static Object getSessionAttribute(String key){
        Object object = null;
        try{
            object = getSession().getAttribute(key);
        }catch (Exception e){
            log.error("从session中取值失败,key=[{}]",key);
        }
        return object;
    }

    /**
     * 设置session超时时间
     * @auth sunpeikai
     * @param
     * @return
     */
    public static void setSessionExpireTime(int second){
        getSession().setMaxInactiveInterval(second);
    }

    /**
     * 获取session
     * @auth sunpeikai
     * @param
     * @return
     */
    public static HttpSession getSession(){
        HttpServletRequest request = getHttpServletRequest();
        return request.getSession();
    }

    /**
     * 获取HttpServletRequest
     * @auth sunpeikai
     * @param
     * @return
     */
    public static HttpServletRequest getHttpServletRequest(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static HttpServletResponse getHttpServletResponse(){
        return ((ServletWebRequest) RequestContextHolder.getRequestAttributes()).getResponse();
    }
}
