package com.lh.jpa.dao;

import com.lh.jpa.entity.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * > 这个接口是扩展了repository， 在这个接口里面默认给大家声明好了一些增删改查的方法，此处给大家演练一个查询所有用户的操作
 *
 * @author liuhe
 * @date 2020/03/27
 */
public interface IStuDao extends CrudRepository<Student, Integer> {
}
