package cn.cyl.controller;

import cn.cyl.domain.Department;
import cn.cyl.domain.Result;
import cn.cyl.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/deptv2")//写在类上指定当前处理器路径
public class DepartmentV2Controller {

    @Autowired
    IDepartmentService departmentService;

    @RequestMapping(path="/listUI",method = RequestMethod.GET)
    public String listUI(){
        return "list_depts";
    }

    //地址上带UI表示打开页面，不带的表示返回数据
    @RequestMapping(path="/list",method = RequestMethod.GET)
    //将list调jackson转成json字符串
    public @ResponseBody Object list(){
        //业务逻辑 调用查找所有的部门的方法
        List<Department> list =  departmentService.findAllDepartments();
        return Result.init(200,"",list);//返回对象需要被转成json字符串
    }

    //根据id删除
    @RequestMapping(path = "/delete",method = RequestMethod.GET)
    public @ResponseBody Object delete(int did){
        try {
            departmentService.deleteDepartmentById(did);
            return Result.init(200,"删除成功",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.init(-200,"删除失败",null);
    }

    //保存操作，一般都是post提交方式
    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public @ResponseBody Object add(Department department){
        //判断是否为空值
        if (department.getDname()!=null&&!"".equals(department.getDname())) {
            try {
                departmentService.saveDepartment(department);
                return Result.init(200, "添加成功", null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Result.init(-200,"添加失败",null);
    }

    //根据id查询，（数据回显第一步）
    @RequestMapping(path = "/find",method = RequestMethod.GET)
    public @ResponseBody Object find(Integer did){
        if (did != null){
            Department dept = departmentService.findDepartmentById(did);
            if (dept != null){
                return Result.init(200,null,dept);
            }
        }
        return Result.init(-200,"没有查询结果",null);
    }

    //根据传入新的对象的did，其原来对应的dname的值修改为传入新对象的dname
    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public @ResponseBody Object update(Department dept){
        if (dept.getDid()!=null){
            try {
                departmentService.updateDepartmentById(dept);
                return Result.init(200,"修改成功",null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Result.init(-200,"修改失败",null);
    }
}
