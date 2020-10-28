package cn.cyl.service;


import cn.cyl.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestPersonServiceImpl {
    //创建日志类对象
    private static final Logger log = LoggerFactory.getLogger(TestPersonServiceImpl.class.getName());

    @Autowired
    IPersonService iPersonService;

    @Test
    public void test01(){//编写两个业务功能 1.查找所有的person 2.保存一个person
        //调用 查询方法
        log.info(iPersonService+"");
        List<Person> list = iPersonService.findAll();
        //调用 保存方法
        log.info(list+"");
        Person person = new Person("jack",100.00);
        iPersonService.savePerson(person);
    }

    @Test
    public void test02(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("jack",100.00));
        list.add(new Person("rose",200.00));
        list.add(new Person("tony",300.00));
        iPersonService.savePersons(list);
    }
}
