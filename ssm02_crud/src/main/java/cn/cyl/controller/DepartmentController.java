package cn.cyl.controller;

import cn.cyl.domain.Department;
import cn.cyl.service.IDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/dept")
public class DepartmentController extends HttpServlet {
    //日志类对象
    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private IDepartmentService iDepartmentService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        List<Department> depts = iDepartmentService.findAllDepartments();
        log.info("list   depts="+depts);
        //数据添加到页面
        model.addAttribute("depts",depts);
        return "list_depts";
    }

    @RequestMapping(path ="/save",method = {RequestMethod.POST,RequestMethod.GET})
    public String save(Department dept,Model model){
        if (dept.getDname() != null && !"".equals(dept.getDname())) {
            iDepartmentService.saveDepartment(dept);
            log.info("save dept="+dept);
            return "redirect:/dept/list";
        }else{
            model.addAttribute("error_msg","部门名称不能为空");
            return "forward:/add_dept.jsp";
        }
    }

    @RequestMapping(path = "/delete",method = RequestMethod.GET)
    public String delete(Integer did){
        log.info("delete id="+did);
        iDepartmentService.deleteDepartmentById(did);
        return "redirect:/dept/list";
    }

    @RequestMapping(path = "/updateUI",method = RequestMethod.GET)
    public String updateUI(Integer did,Model model){
        log.info("updateUI id="+did);
        Department department = iDepartmentService.findDepartmentById(did);
        model.addAttribute("dept",department);
        return "update_dept";
    };

    @RequestMapping(path = "update",method = RequestMethod.POST)
    public String update(Department department){
        log.info("update   dept="+department);
        iDepartmentService.updateDepartmentById(department);
        //跳到查询页面
        return "redirect:/dept/list";
    }
}
