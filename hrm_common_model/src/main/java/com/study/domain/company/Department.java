package com.study.domain.company;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "co_department")
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Department implements Serializable {

    @ApiModelProperty(value = "主键id", required = true,hidden = true)
    @Id
    private String id;              // id
    @ApiModelProperty(value = "企业id")
    private String companyId;       // 企业id
    @ApiModelProperty(value = "上级部门id")
    private String parentId;        // 上级部门id
    @ApiModelProperty(value = "部门名称")
    private String name;            // 部门名称
    @ApiModelProperty(value = "部门编号")
    private String code;            // 部门编号
    @ApiModelProperty(value = "部门类别")
    private String category;        // 部门类别
    @ApiModelProperty(value = "部门负责人id")
    private String managerId;       // 部门负责人id
    @ApiModelProperty(value = "城市")
    private String city;            // 城市
    @ApiModelProperty(value = "介绍")
    private String introduce;       // 介绍
    @ApiModelProperty(value = "部门负责人")
    private String manager;         // 部门负责人
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;        // 创建时间

}
