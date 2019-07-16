package com.personal.business.exception;

import com.personal.business.Enum.ResultEnum;
import lombok.Data;

/**
 * 业务异常
 *
 * @author framework
 */
@Data
public class LoginException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    protected  String status;

    protected  String statusDesc;

    public LoginException(String status, String statusDesc) {
        super(statusDesc);
        this.status = status;
        this.statusDesc = statusDesc;
    }

    public LoginException(ResultEnum resultEnum){
        super(resultEnum.getStatusDesc());
        this.status = resultEnum.getStatus();
        this.statusDesc = resultEnum.getStatusDesc();
    }

    public LoginException(String statusDesc) {
        super(statusDesc);
        this.status = ResultEnum.ERROR_DEFAULT.getStatus();
        this.statusDesc = statusDesc;
    }

    public LoginException(String statusDesc, Throwable e) {
        super(statusDesc, e);
        this.status = ResultEnum.ERROR_DEFAULT.getStatus();
        this.statusDesc = statusDesc;
    }
}
