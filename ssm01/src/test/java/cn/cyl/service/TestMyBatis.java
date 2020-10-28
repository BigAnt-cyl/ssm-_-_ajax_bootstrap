package cn.cyl.service;

import cn.cyl.dao.IPersonDao;
import cn.cyl.domain.Person;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    private SqlSession session;

    @Before
    public void init(){
        //加载配置文件
        InputStream in = TestMyBatis.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        session = factory.openSession();
    }

    @After
    public void destory(){
        session.commit();
        session.close();
    }

    @Test
    public void test01(){
        IPersonDao dao =  session.getMapper(IPersonDao.class);
        dao.savePerson(new Person("tony",200.00));
    }

    @Test
    public void test02(){
        IPersonDao dao =  session.getMapper(IPersonDao.class);
        List<Person> list = dao.findAll();
        System.out.println(list);
    }
}
