/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.exception;

import com.personal.business.base.Return;
import com.personal.business.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author sunpeikai
 * @version GlobalExceptionHandler, v0.1 2019/7/16 19:07
 * @description
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 请求方式不支持
     */
    @ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
    public Return handleException(HttpRequestMethodNotSupportedException e) {
        log.error(e.getMessage(), e);
        return Return.fail("不支持' " + e.getMethod() + "'请求");
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public Return notFount(RuntimeException e) {
        log.error("运行时异常:", e);
        return Return.fail(ResultEnum.ERROR_DEFAULT);
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public Return handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Return.fail(ResultEnum.ERROR_DEFAULT);
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public Return handleBusiness(Exception e) {
        log.error(e.getMessage(), e);
        return Return.fail(e.getMessage());
    }

    /**
     * 参数校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Return handleException(MethodArgumentNotValidException e) {
        String errorMsg = e.getBindingResult().getAllErrors().get(0).getDefaultMessage().replace("{}","不能为空");
        log.error("参数校验异常:" + errorMsg);
        return Return.fail(errorMsg);
    }

    /**
     * 拦截shiro抛出的未认证异常(未登录)
     * @param e
     * @return
     */
    @ExceptionHandler(UnauthenticatedException.class)
    public Return handleException(UnauthenticatedException e) {
        log.error("[用户未登录:{}]",e.getMessage());
        return Return.fail(ResultEnum.ERROR_NOT_LOGIN);
    }

    /**
     * 拦截shiro抛出的没有权限异常
     * @param e
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    public Return handleException(UnauthorizedException e) {
        log.error("[该用户没有权限:{}]",e.getMessage());
        return Return.fail(ResultEnum.ERROR_NOT_AUTH);
    }
}
