package com.learn.dept.dao;

import com.learn.dept.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Panlf
 * @date 2019/12/16
 */
public interface DeptDao extends JpaRepository<Dept, Integer>,JpaSpecificationExecutor<Dept> {
}
