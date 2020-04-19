package com.study.domain.company;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类代码
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "co_company")
public class Company implements Serializable {
    private static final long serialVersionUID = 594829320797158219L;
    @ApiModelProperty(value = "主键id", required = true,hidden = true)
    @Id
    private String id;
    @ApiModelProperty(value = "公司名称")
    private String name;                    // 公司名称
    @ApiModelProperty(value = "企业登录账号ID", required = true)
    private String managerId;               // 企业登录账号ID
    @ApiModelProperty(value = "当前版本")
    private String version;                 // 当前版本
    @ApiModelProperty(value = "续期时间")
    private Date renewalDate;               // 续期时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "到期时间")
    private Date expirationDate;            // 到期时间
    @ApiModelProperty(value = "公司地区")
    private String companyArea;             // 公司地区
    @ApiModelProperty(value = "公司地址")
    private String companyAddress;          // 公司地址
    @ApiModelProperty(value = "营业执照-图片id")
    private String businessLicenseId;       // 营业执照-图片id
    @ApiModelProperty(value = "法人代表")
    private String legalRepresentative;     // 法人代表
    @ApiModelProperty(value = "公司电话")
    private String companyPhone;            // 公司电话
    @ApiModelProperty(value = "邮箱")
    private String mailbox;                 // 邮箱
    @ApiModelProperty(value = "公司规模")
    private String companySize;             // 公司规模
    @ApiModelProperty(value = "所属行业")
    private String industry;                // 所属行业
    @ApiModelProperty(value = "备注")
    private String remarks;                 // 备注
    @ApiModelProperty(value = "审核状态")
    private String auditState;              // 审核状态
    @ApiModelProperty(value = "状态")
    private Integer state;                  // 状态
    @ApiModelProperty(value = "余额")
    private Double balance;                 // 余额
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;                // 创建时间
}
