package cn.cyl.service.impl;

import cn.cyl.dao.IDepartmentDao;
import cn.cyl.domain.Department;
import cn.cyl.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    IDepartmentDao dao;

    @Override
    public List<Department> findAllDepartments() {
        List<Department> list = dao.findAll();
        return list;
    }

    @Override
    public void saveDepartment(Department dept) {
        dao.save(dept);
    }

    @Override
    public void deleteDepartmentById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void updateDepartmentById(Department dept) {
        dao.update(dept);
    }

    @Override
    public Department findDepartmentById(int did) {
        return dao.findById(did);
    }

}

