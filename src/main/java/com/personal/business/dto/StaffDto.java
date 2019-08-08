/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author sunpeikai
 * @version StaffDto, v0.1 2019/8/8 16:26
 * @description
 */
@Data
public class StaffDto {
    private Integer id;
    private String positionName;
    private String companyName;
    private LocalDateTime createTime;
}
