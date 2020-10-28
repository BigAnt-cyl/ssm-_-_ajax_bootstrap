package cn.cyl.dao.impl;

import cn.cyl.dao.IPersonDao;
import cn.cyl.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/*	整合Mybatis后，dao层功能由Mybatis完成，此注解就可以去掉了，不然会多个实现类
	然后后使用@Deprecated注解表示该类过时，不会再用了*/
//@Repository
@Deprecated
public class PersonDaoImpl implements IPersonDao {
    @Override
    public List<Person> findAll() {
        System.out.println("查询所有    findAll Dao");
        //假数据库
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person person = new Person("jack"+i,100.00);
            person.setId(i+1);
            list.add(person);
        }
        return list;
    }

    @Override
    public void savePerson(Person person) {
        System.out.println("保存  save Dao");
    }
}
