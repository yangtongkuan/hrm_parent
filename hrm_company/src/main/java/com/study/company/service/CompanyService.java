package com.study.company.service;

import com.study.common.utils.IdWorker;
import com.study.company.dao.CompanyDao;
import com.study.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private IdWorker idWorker;

    // todo: 创建公司
    public Company create(Company company) {
        Long id = idWorker.nextId();
        company.setAuditState("0");     // 待审核
        company.setState(1);            // 启用
        company.setBalance(0.0d);
        company.setCreateTime(new Date());
        company.setId(String.valueOf(id));
        return companyDao.save(company);
    }

    // todo: 修改公司
    public Company modify(Company company) {
        return companyDao.save(company);
    }

    // todo ：
    public Company findById(String id) {
        return companyDao.findById(id).get();
    }

    // todo:
    public void deleteById(String id) {
        companyDao.deleteById(id);
    }

    // todo : findAll
    public List<Company> findAll(){
        return companyDao.findAll();
    }

}
