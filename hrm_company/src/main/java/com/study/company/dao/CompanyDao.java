package com.study.company.dao;

import com.study.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

// todo : 公司数据 op
public interface CompanyDao extends JpaRepository<Company, String>, JpaSpecificationExecutor<Company> {
}
