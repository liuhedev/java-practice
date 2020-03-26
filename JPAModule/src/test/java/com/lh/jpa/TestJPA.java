package com.lh.jpa;

import com.lh.jpa.bean.Student;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author liuhe
 * @date 2020/03/26
 */
public class TestJPA {

    @Test
    public void testJPA() {
//        1.创建实体管理工厂，取xml中配置单元名称
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("student");
//        2.创建实体管理员
        EntityManager entityManager = factory.createEntityManager();
//        3.获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
//        4.开启事务
        transaction.begin();
        Student student = new Student();
        student.setName("刘博城");
        student.setAge(80);
//        5.持久化，保存数据到库
        entityManager.persist(student);
//        提交事务
        transaction.commit();
//        关闭管理员
        entityManager.close();
//        关闭工厂，可以不关心
        factory.close();

    }
}
