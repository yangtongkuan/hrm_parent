package com.study.company.dao;

import com.study.domain.company.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

// todo 部门
public interface DepartmentDao extends JpaRepository<Department, String>, JpaSpecificationExecutor<Department> {
}
