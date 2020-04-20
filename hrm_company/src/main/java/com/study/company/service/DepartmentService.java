package com.study.company.service;

import com.study.common.entity.ResultCode;
import com.study.common.exception.CommonException;
import com.study.common.utils.IdWorker;
import com.study.company.dao.DepartmentDao;
import com.study.domain.company.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.print.DocFlavor;
import java.util.Date;
import java.util.List;

// todo : department service
@Service
public class DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private IdWorker idWorker;

    // todo: create an department
    public Department save(Department department) {
        department.setId(String.valueOf(idWorker.nextId()));
        department.setCreateTime(new Date());
        return departmentDao.save(department);
    }

    // todo : update department
    public Department update(Department department) throws CommonException {
        Department department_db = departmentDao.findById(department.getId()).orElse(null);
        if (department_db == null) {
            throw new CommonException(ResultCode.NOFUND);
        }
        department_db.setName(department.getName());
        department_db.setIntroduce(department.getIntroduce());
        department_db.setCode(department.getCode());
        return departmentDao.save(department_db);
    }

    // todo : find by departmentId
    public Department findById(String departmentId) {
        return departmentDao.findById(departmentId).orElse(null);
    }

    // todo : search all department by companyId
    public List<Department> findAll(String companyId) {
        Specification sp = new Specification<Department>() {
            /**
             *  构造查询条件
             * @param root  ： 包含对象的数据
             * @param sq    ：
             * @param cb    : 构造查询条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> sq, CriteriaBuilder cb) {
                return cb.equal(root.get("companyId").as(String.class), companyId);
            }
        };
        return departmentDao.findAll(sp);
    }

    // todo : delete by departmentId
    public void deleteByDepartmentId(String departmentId) {
        departmentDao.deleteById(departmentId);
    }


}
