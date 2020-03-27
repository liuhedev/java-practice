package com.lh.jpa.controller;

import com.lh.jpa.entity.Student;
import com.lh.jpa.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liuhe
 * @date 2020/03/27
 */
@RestController
public class StuController {

    @Autowired
    private IStuService stuService;

    private int id = 10;

    @RequestMapping("/save")
    public String save() {
        Student student = new Student();
//        student.setId(5);
        student.setName("习大大" + id);
        student.setAge(64);
        id++;
        stuService.save(student);
        return "保存成功";
    }

    @RequestMapping("/findAll")
    public List<Student> findAll() {
        return stuService.findAll();
    }

    @RequestMapping("/findStu/{id}")
    public Student findById(@PathVariable(name = "id") Integer id) {
        return stuService.findById(id);
    }

    @RequestMapping("/find")
    public List<Student> findByPage(@RequestParam(name = "page") Integer page,
                                    @RequestParam(name = "size") Integer size) {
        //这里ctrl + T 看实现类，然后找PageRequest ，别说你不会哈~~
        // page : page表示请求的页码数， 从0开始，0就代表第一页大家。
        //size : 表示每页拿多少条记录
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> byPage = stuService.findByPage(pageable);
        return byPage.getContent();
    }
}
