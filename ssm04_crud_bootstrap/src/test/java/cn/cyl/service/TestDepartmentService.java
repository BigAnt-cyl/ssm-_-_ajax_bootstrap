package cn.cyl.service;

import cn.cyl.domain.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestDepartmentService {
    //日志类对象
    private static final Logger log = LoggerFactory.getLogger(TestDepartmentService.class);
    @Autowired
    IDepartmentService service;

    //查询所有数据
    @Test
    public void test01() {
        List<Department> list = service.findAllDepartments();
        log.info("test01 list=" + list);
    }

    //添加一行数据
    @Test
    public void test02() {//
        Department dept = new Department("UI设计部门");
        service.saveDepartment(dept);
    }

    //根据id删除
    @Test
    public void test03() {
        service.deleteDepartmentById(1);
    }

    //通过id修改
    @Test
    public void test04(){
        Department department = new Department();
        department.setDid(3);
        department.setDname("最牛部门");
        service.updateDepartmentById(department);
    }

    //通过id查询
    @Test
    public void test05(){
        Department department = service.findDepartmentById(2);
        log.info("test05   department="+department);
    }
}


