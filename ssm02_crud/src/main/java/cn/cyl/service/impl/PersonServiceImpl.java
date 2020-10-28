package cn.cyl.service.impl;

import cn.cyl.dao.IPersonDao;
import cn.cyl.domain.Person;
import cn.cyl.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*  @Service("personService")
    IPersonService的实现类就一个，我们就不给它起id名了。*/
@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    IPersonDao iPersonDao;

    @Override
    public List<Person> findAll() {
        List<Person> list = iPersonDao.findAll();
        return list;
    }

    @Override
    public void savePerson(Person person) {
        iPersonDao.savePerson(person);
    }

    @Override
    public void savePersons(List<Person> persons) {
        for (int i = 0; i < persons.size(); i++) {
            //除0异常
            /*if (i==2){
                System.out.println(i/0);
            }*/
            iPersonDao.savePerson(persons.get(i));
        }
    }
}
