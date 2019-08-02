/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.request;

import com.personal.business.base.BasePage;
import lombok.Data;

/**
 * @author sunpeikai
 * @version CompanyRequest, v0.1 2019/8/1 9:57
 * @description
 */
@Data
public class CompanyRequest extends BasePage {

    private String fullName;

    private String creditCode;

    private String companyCode;

    private Integer type;

    private Integer status;
}
