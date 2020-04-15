package com.study.company.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.study.common.entity.Result;
import com.study.common.entity.ResultCode;
import com.study.common.exception.CommonException;
import com.study.company.service.CompanyService;
import com.study.domain.company.Company;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

// todo : 公司
@Api(value = "企业管理", tags = "企业管理")
@ApiSort(1)
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // todo  添加企业
    @PostMapping(value = "")
    @ApiOperation("添加企业")
    @ApiOperationSupport(ignoreParameters = {"company.id", "company.createTime"})
    public Result<Company> create(@RequestBody Company company) {
        company = companyService.create(company);
        return new Result<Company>(ResultCode.SUCCESS, company);
    }

    // todo: 根据id更新企业信息
    @PutMapping("/{id}")
    @ApiOperation("更新企业")
    @ApiParam(name = "id", required = true)
    public Result<Company> modify(@PathVariable(name = "id") String id, @RequestBody Company company) throws CommonException {
        Company company_db = companyService.findById(id);
        if (company_db == null) {
            throw new CommonException(ResultCode.NOFUND);
        }
        company_db.setName(company.getName());
        company_db.setRemarks(company.getRemarks());
        company_db.setState(company.getState());
        company_db.setAuditState(company.getAuditState());
        company_db = companyService.modify(company_db);
        return new Result<Company>(ResultCode.SUCCESS, company_db);
    }

    // todo: 根据id 删除企业信息
    @DeleteMapping(value = "/{id}")
    @ApiOperation("删除企业")
    public Result delete(@PathVariable("id") String id) {
        companyService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

    // todo: 根据id 获取配送公司信息
    @GetMapping("/{id}")
    @ApiOperation("获取企业")
    @ApiParam()
    public Result<Company> findById(@PathVariable(name = "id") String id) {
        Company company = companyService.findById(id);
        return new Result<Company>(ResultCode.SUCCESS, company);
    }

    // todo: 获取企业列表
    @GetMapping(value = "")
    @ApiOperation("获取企业列表")
    public Result<List<Company>> findAll() {
        List<Company> companyList = companyService.findAll();
        return new Result<List<Company>>(ResultCode.SUCCESS, companyList);
    }
}
