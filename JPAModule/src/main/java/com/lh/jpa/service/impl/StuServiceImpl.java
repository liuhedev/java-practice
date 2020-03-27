package com.lh.jpa.service.impl;

import com.lh.jpa.dao.IStuDao;
import com.lh.jpa.dao.IStuCustomDao;
import com.lh.jpa.dao.IStuPageDao;
import com.lh.jpa.entity.Student;
import com.lh.jpa.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuhe
 * @date 2020/03/27
 */
@Service
public class StuServiceImpl implements IStuService {

    @Autowired
    private IStuDao iStuDao;

    @Autowired
    private IStuCustomDao iStuCustomDao;

    @Autowired
    private IStuPageDao iStuPageDao;

    @Override
    public void save(Student student) {
        iStuDao.save(student);
    }

    @Override
    public List<Student> findAll() {
        Iterable<Student> all = iStuDao.findAll();
        return (List<Student>) all;
    }

    @Override
    public Student findById(int uid) {
        return iStuCustomDao.findById(uid);
    }

    @Override
    public Page<Student> findByPage(Pageable pageable) {
        return iStuPageDao.findAll(pageable);
    }
}
