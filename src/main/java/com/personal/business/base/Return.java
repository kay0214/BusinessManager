/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.base;

import com.personal.business.Enum.ResultEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author sunpeikai
 * @version Return, v0.1 2019/7/16 19:09
 * @description
 */
@Data
@NoArgsConstructor
public class Return<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String status;
    private String statusDesc;
    private T data;
    private Return(ResultEnum resultEnum){this(resultEnum,resultEnum.getStatusDesc(),null);}
    private Return(ResultEnum resultEnum, String statusDesc) {
        this(resultEnum, statusDesc, null);
    }

    private Return(ResultEnum resultEnum, T data) {
        this(resultEnum, resultEnum.getStatusDesc(), data);
    }

    private Return(ResultEnum resultEnum, String statusDesc, T data) {
        this(resultEnum.getStatus(), statusDesc, data);
    }

    private Return(String status,String statusDesc,T data){
        this.status = status;
        this.statusDesc = statusDesc;
        this.data = data;
    }


    /**
     * 返回R
     *
     * @param data 数据
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> Return<T> data(T data) {
        return data(data, ResultEnum.SUCCESS_DEFAULT.getStatusDesc());
    }

    /**
     * 返回R
     *
     * @param data 数据
     * @param statusDesc  消息
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> Return<T> data(T data, String statusDesc) {
        return data(ResultEnum.SUCCESS_DEFAULT.getStatus(), data, statusDesc);
    }

    /**
     * 返回R
     *
     * @param status 状态码
     * @param data 数据
     * @param statusDesc  消息
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> Return<T> data(String status, T data, String statusDesc) {
        return new Return<>(status, data == null ? ResultEnum.ERROR_HAVE_NO_DATA.getStatusDesc() : statusDesc, data);
    }

    /**
     * 返回R
     *
     * @param statusDesc 消息
     * @param <T> T 泛型标记
     * @return R
     */
    public static <T> Return<T> success(String statusDesc) {
        return new Return<>(ResultEnum.SUCCESS_DEFAULT, statusDesc);
    }

    public static <T> Return<T> success(T t) {
        return new Return<>(ResultEnum.SUCCESS_DEFAULT, t);
    }


    /**
     * 返回R
     *
     * @param <T> T 泛型标记
     * @return R
     */
    public static <T> Return<T> success() {
        return new Return<>(ResultEnum.SUCCESS_DEFAULT);
    }

    /**
     * 返回R
     *
     * @param resultEnum 业务代码
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> Return<T> success(ResultEnum resultEnum) {
        return new Return<>(resultEnum);
    }

    /**
     * 返回R
     *
     * @param resultEnum 业务代码
     * @param statusDesc        消息
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> Return<T> success(ResultEnum resultEnum, String statusDesc) {
        return new Return<>(resultEnum, statusDesc);
    }

    /**
     * 返回R
     *
     * @param statusDesc 消息
     * @param <T> T 泛型标记
     * @return R
     */
    public static <T> Return<T> fail(String statusDesc) {
        return new Return<>(ResultEnum.ERROR_DEFAULT, statusDesc);
    }

    /**
     * 返回R
     *
     * @param status 状态码
     * @param statusDesc  消息
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> Return<T> fail(String  status, String statusDesc) {
        return new Return<>( status, statusDesc, null);
    }

    /**
     * 返回R
     *
     * @param resultEnum 业务代码
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> Return<T> fail(ResultEnum resultEnum) {
        return new Return<>(resultEnum);
    }

}
