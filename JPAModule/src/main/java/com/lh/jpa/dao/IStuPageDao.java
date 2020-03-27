package com.lh.jpa.dao;

import com.lh.jpa.entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

/**
 * 这个接口是是CrudRepository的扩展接口，除了兼备增删改查之外，它还扩展了分页查询&排序的效果。
 *
 * 以下是这个接口的代码声明
 * @author liuhe
 * @date 2020/03/27
 */
public interface IStuPageDao extends PagingAndSortingRepository<Student, Integer> {
}
