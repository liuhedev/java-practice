package com.lh.jpa.service;

import com.lh.jpa.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author liuhe
 * @date 2020/03/27
 */
public interface IStuService {
    void save(Student student);

    List<Student> findAll();

    Student findById(int uid);

    Page<Student> findByPage(Pageable pageable);
}
