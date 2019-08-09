/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.request;

import lombok.Data;

/**
 * @author sunpeikai
 * @version PositionCompanyRequest, v0.1 2019/8/9 14:05
 * @description
 */
@Data
public class PositionCompanyRequest {
    private String companyIds;
    private Integer positionId;
}
