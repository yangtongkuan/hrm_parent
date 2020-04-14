package com.study.domain.company;

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
    @Id
    private String id;

    private String name;                    // 公司名称
    private String managerId;               // 企业登录账号ID
    private String version;                 // 当前版本
    private Date renewalDate;               // 续期时间
    private Date expirationDate;            // 到期时间
    private String companyArea;             // 公司地区
    private String companyAddress;          // 公司地址
    private String businessLicenseId;       // 营业执照-图片id
    private String legalRepresentative;     // 法人代表
    private String companyPhone;            // 公司电话
    private String mailbox;                 // 邮箱
    private String companySize;             // 公司规模
    private String industry;                // 所属行业
    private String remarks;                 // 备注
    private String auditState;              // 审核状态
    private Integer state;                  // 状态
    private Double balance;                 // 余额
    private Date createTime;                // 创建时间
}
