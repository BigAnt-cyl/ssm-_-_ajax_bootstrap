package cn.cyl.service;

import cn.cyl.domain.Person;
import java.util.List;

public interface IPersonService {
    //查询所有用户
    List<Person> findAll();

    //添加一个用户
    void savePerson(Person person);

    //添加多个用户
    void savePersons(List<Person> persons);
}