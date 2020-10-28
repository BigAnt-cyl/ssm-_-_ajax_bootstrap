package cn.cyl.controller;

import cn.cyl.domain.Department;
import cn.cyl.domain.Result;
import cn.cyl.service.IDepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    //-----------bootstrap
    @RequestMapping(path = "tempUI",method = RequestMethod.GET)
    public String tempUI(){
        return "temp";
    }

    @RequestMapping(path = "addUIV3",method = RequestMethod.GET)
    public String addUIV3(){
        return "add_v3";
    }

    @RequestMapping(path = "editUIV3",method = RequestMethod.GET)
    public String editUIV3(){
        return "edit_v3";
    }

    @RequestMapping(path = "listUIV3",method = RequestMethod.GET)
    public String listUIV3(){
        return "list_v31";
    }

    @RequestMapping(path="/pageUI",method = RequestMethod.GET)
    public String page(Model model, Integer currPage, Integer pageSize){//你需要第几页数据，每页数据多条
        log.info("page currPage="+currPage);
        log.info("page pageSize="+pageSize);

        if(currPage==null){
            currPage=1;
        }
        if (pageSize==null){
            pageSize=5;
        }

        //给定分页参数
        PageHelper.startPage(currPage,pageSize);
        //一个全查，其他都交给PageInterceptor
        List<Department> list = iDepartmentService.findAllDepartments();

        PageInfo<Department> pi = new PageInfo<>(list);

        model.addAttribute("pi",pi);
        return "list_v3";
    }

}
