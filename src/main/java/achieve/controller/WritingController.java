package achieve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/writing")
public class WritingController {

    @RequestMapping("/index")
    public String index(){
        return "writing/index";
    }

    @RequestMapping("/add")
    public String add(){
        return "writing/add";
    }

    @RequestMapping("/show")
    public String show(){
        return "writing/show";
    }

    @RequestMapping("/edit")
    public String edit(){
        return "writing/edit";
    }

}
