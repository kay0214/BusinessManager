package com.personal.business.exception;

import com.personal.business.enums.ResultEnum;
import lombok.Data;

/**
 * 业务异常
 *
 * @author framework
 */
@Data
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    protected  String status;

    protected  String statusDesc;

    public BusinessException(String status, String statusDesc) {
        super(statusDesc);
        this.status = status;
        this.statusDesc = statusDesc;
    }

    public BusinessException(ResultEnum resultEnum){
        super(resultEnum.getStatusDesc());
        this.status = resultEnum.getStatus();
        this.statusDesc = resultEnum.getStatusDesc();
    }

    public BusinessException(String statusDesc) {
        super(statusDesc);
        this.status = ResultEnum.ERROR_DEFAULT.getStatus();
        this.statusDesc = statusDesc;
    }

    public BusinessException(String statusDesc, Throwable e) {
        super(statusDesc, e);
        this.status = ResultEnum.ERROR_DEFAULT.getStatus();
        this.statusDesc = statusDesc;
    }
}
