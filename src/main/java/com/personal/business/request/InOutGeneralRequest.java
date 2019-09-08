/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.request;

import com.personal.business.base.BasePage;
import lombok.Data;

/**
 * @author sunpeikai
 * @version InOutGeneralRequest, v0.1 2019/9/8 14:22
 * @description
 */
@Data
public class InOutGeneralRequest extends BasePage {
    private String mapCode;
    private Integer inOut;
    private Integer inOutType;
    private String inOutNo;
    private Integer companyId;

}
