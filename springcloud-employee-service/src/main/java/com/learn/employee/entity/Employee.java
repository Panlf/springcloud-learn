package com.learn.employee.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Panlf
 * @date 2019/12/16
 */
@Entity(name="employee")
@Data
public class Employee {
    @Id
    private Integer id;
    private String name;
    private Integer deptId;

}
