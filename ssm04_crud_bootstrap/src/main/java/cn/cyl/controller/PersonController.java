package cn.cyl.controller;

import cn.cyl.domain.Person;
import cn.cyl.service.IPersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    IPersonService iPersonService;

    @RequestMapping(path = "/list",method = RequestMethod.GET)
    public String list(Model model){
        List<Person> list = iPersonService.findAll();
        log.info("所有信息 list :"+list);

        model.addAttribute("list",list);
        return "list";
    }
}
