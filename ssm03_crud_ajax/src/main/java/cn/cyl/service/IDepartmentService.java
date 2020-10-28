package cn.cyl.service;

import cn.cyl.domain.Department;

import java.util.List;

public interface IDepartmentService {
    //查询所有部门
    List<Department> findAllDepartments();
    //添加一个新的部门
    void saveDepartment(Department dept);
    //删除指定id的部门数据
    void deleteDepartmentById(int i);
    //根据指定id修改部门名称
    void updateDepartmentById(Department dept);
    //查找指定id的部门数据
    Department findDepartmentById(int did);

}
