package achieve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/paper")
public class PaperController {

    @RequestMapping("/index")
    public String index(){
        return "paper/index";
    }

    @RequestMapping("/add")
    public String add(){
        return "paper/add";
    }

    @RequestMapping("/show")
    public String show(){
        return "paper/show";
    }

    @RequestMapping("/edit")
    public String edit(){
        return "paper/edit";
    }

}
