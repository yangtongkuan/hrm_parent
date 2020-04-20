package com.study.domain.company.res;

import com.study.domain.company.Company;
import com.study.domain.company.Department;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptListResult {
    @ApiModelProperty(value = "公司id")
    private String companyId;
    @ApiModelProperty(value = "公司名称")
    private String companyName;
    @ApiModelProperty(value = "公司法人")
    private String companyManager;
    @ApiModelProperty(value = "部门")
    private List<Department> depts;

    public DeptListResult(Company company, List<Department> list) {
        this(company.getId(), company.getName(), company.getLegalRepresentative(), list);
    }
}
