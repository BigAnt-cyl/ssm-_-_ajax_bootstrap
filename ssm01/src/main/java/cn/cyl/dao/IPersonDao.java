package cn.cyl.dao;

import cn.cyl.domain.Person;
import java.util.List;

public interface IPersonDao {

    //查询所有
    List<Person> findAll();

    //保存
    void savePerson(Person person);
}
