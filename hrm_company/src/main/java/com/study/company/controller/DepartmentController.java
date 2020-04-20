package com.study.company.controller;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.study.common.entity.Result;
import com.study.common.entity.ResultCode;
import com.study.common.exception.CommonException;
import com.study.company.service.CompanyService;
import com.study.company.service.DepartmentService;
import com.study.domain.company.Company;
import com.study.domain.company.Department;
import com.study.domain.company.res.DeptListResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// todo department controller
@RestController
@RequestMapping(value = "/company")
@Api(tags = "部门管理")
@ApiSort(value = 2)
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CompanyService companyService;

    // todo: create a department
    @ApiOperation("添加部门")
    @PostMapping(value = "/department")
    public Result<Department> save(@RequestBody Department department) {
        String companyId = "1";
        department.setCompanyId(companyId);
        department = departmentService.save(department);
        return new Result<Department>(department);
    }

    // todo : list of department by companyId
    @ApiOperation("获取企业部门列表")
    @GetMapping(value = "/department")
    public Result<DeptListResult> findAll() throws CommonException {
        String companyId = "1";
        Company company = companyService.findById(companyId);
        if (company == null) {
            throw new CommonException(ResultCode.NOFUND);
        }
        List<Department> departmentList = departmentService.findAll(companyId);
        DeptListResult deptListResult = new DeptListResult(company, departmentList);
        return new Result<DeptListResult>(deptListResult);
    }

    // todo : find by departmentId
    @ApiOperation("获取部门详情")
    @GetMapping(value = "/department/{id}")
    public Result<Department> detail(@PathVariable(name = "id") String id) {
        Department department = departmentService.findById(id);
        return new Result<Department>(department);
    }

    // todo : delete by departmentId
    @DeleteMapping(value = "/department/{id}")
    @ApiOperation("删除部门")
    public Result deleteByCompanyId(@PathVariable(name = "id") String id) {
        departmentService.deleteByDepartmentId(id);
        return Result.SUCCESS();
    }

    // todo : delete by departmentId
    @PutMapping(value = "/department/{id}")
    @ApiOperation("更新部门")
    public Result<Department> update(@PathVariable(name = "id") String id, @RequestBody Department department) throws CommonException {
        department.setId(id);
        department = departmentService.update(department);
        return new Result(department);
    }

}
