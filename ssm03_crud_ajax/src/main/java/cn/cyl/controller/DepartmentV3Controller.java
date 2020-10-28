package cn.cyl.controller;

import cn.cyl.domain.Department;
import cn.cyl.domain.Result;
import cn.cyl.service.IDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/deptv3")
public class DepartmentV3Controller {

    private static final Logger log = LoggerFactory.getLogger(DepartmentV3Controller.class);

    @Autowired
    IDepartmentService iDepartmentService;

    @RequestMapping(path = "addUI",method = RequestMethod.GET)
    public String addUI(){
        return "add_dept";
    }

    @RequestMapping(path = "add",method = RequestMethod.POST,consumes = "application/json")
    public @ResponseBody Object add(@RequestBody Department dept){//页面传过来的json数据，如：{"did":null,"dname":"鼓励师"}
        log.info("add dept : " + dept);
        try {
            iDepartmentService.saveDepartment(dept);
            return Result.init(200,"添加成功",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.init(-200,"添加失败",null);
    }
}
