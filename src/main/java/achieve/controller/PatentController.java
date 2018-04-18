package achieve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patent")
public class PatentController {

    @RequestMapping("/index")
    public String index(){
        return "patent/index";
    }

    @RequestMapping("/add")
    public String add(){
        return "patent/add";
    }

    @RequestMapping("/show")
    public String show(){
        return "patent/show";
    }

    @RequestMapping("/edit")
    public String edit(){
        return "patent/edit";
    }

}
