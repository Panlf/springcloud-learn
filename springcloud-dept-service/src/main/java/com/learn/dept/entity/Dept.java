package com.learn.dept.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Panlf
 * @date 2019/12/16
 */
@Data
@Entity(name="dept")
public class Dept {
    @Id
    private Integer id;

    private String deptName;
}
