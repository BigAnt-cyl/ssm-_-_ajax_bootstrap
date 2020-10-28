package cn.cyl.dao;

import cn.cyl.domain.Department;

import java.util.List;

public interface IDepartmentDao {
    //查询所有
    List<Department> findAll();
    //添加一个
    void save(Department dept);
    //根据id删除
    void deleteById(int id);
    //传入对象后，根据id修改
    void update(Department department);
    //根据id查询
    Department findById(int i);
}
