package com.learn.dept.controller;

import com.learn.dept.entity.Dept;
import com.learn.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Panlf
 * @date 2019/12/16
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping(value="get/{id}")
    public Dept findById(@PathVariable Integer id) {
        Dept dept = deptService.findById(id);
        return dept;
    }
}
