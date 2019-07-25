/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunpeikai
 * @version MenuTreeDto, v0.1 2019/7/23 19:21
 * @description
 */
@Data
public class MenuTreeDto {
    private Integer id;
    private String label;
    private List<MenuTreeDto> children = new ArrayList<>();
}
