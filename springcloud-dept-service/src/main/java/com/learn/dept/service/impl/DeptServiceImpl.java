package com.learn.dept.service.impl;

import com.learn.dept.dao.DeptDao;
import com.learn.dept.entity.Dept;
import com.learn.dept.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Panlf
 * @date 2019/12/16
 */
@Service
@Slf4j
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Value("${server.port}")
    private int port;

    @Override
    public Dept findById(Integer id) {
        log.info("目前接口访问的端口为{}",port);
        Optional<Dept> optionCity = deptDao.findById(id);
        return optionCity.get();
    }

    @Override
    public void save(Dept dept) {
        deptDao.save(dept);
    }

    @Override
    public void update(Dept dept) {
        deptDao.save(dept);
    }

    @Override
    public void delete(Integer id) {
        deptDao.deleteById(id);
    }
}
