/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.personal.business.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author sunpeikai
 * @version PositionDto, v0.1 2019/8/9 14:39
 * @description
 */
@Data
public class PositionDto {
    private Integer id;

    /**
     * 岗位名称
     */
    private String name;

    /**
     * 岗位名称
     */
    private String staffs;

    /**
     * 父节点id
     */
    private Integer parentId;

    /**
     * 排序字典
     */
    private Integer orderNum;

    /**
     * 区分部门还是岗位，从数据字典中取得
     */
    private Integer type;

    private Integer status;

    /**
     * 是否已用（0：未用，1：已用）
     */
    private Integer used;

    /**
     * 描述
     */
    private String remark;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private Integer delFlag;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public void handleStaffs(List<String> staffList){
        if(staffList.size()>0){
            StringBuilder staffs = new StringBuilder();
            for(int i=0;i<staffList.size();i++){
                if(i==0){
                    staffs.append(staffList.get(i));
                }else{
                    staffs.append("、").append(staffList.get(i));
                }
            }
            this.setStaffs(staffs.toString());
        }
    }
}
