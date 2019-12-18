package com.learn.dept.service;

import com.learn.dept.entity.Dept;

/**
 * @author Panlf
 * @date 2019/12/16
 */
public interface DeptService {
    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Dept findById(Integer id);

    /**
     * 保存
     * @param dept
     */
    void save(Dept dept);

    /**
     * 更新
     * @param dept
     */
    void update(Dept dept);

    /**
     * 根据ID删除
     * @param id
     */
    void delete(Integer id);
}
