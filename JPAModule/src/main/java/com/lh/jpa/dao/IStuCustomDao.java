package com.lh.jpa.dao;

import com.lh.jpa.entity.Student;
import org.springframework.data.repository.Repository;

/**
 * @author liuhe
 * @date 2020/03/27
 */
public interface IStuCustomDao extends Repository<Student, Integer> {

    /**
     * 根据用户id查询用户
     *
     * @param id
     * @return
     */
    Student findById(int id);
}
