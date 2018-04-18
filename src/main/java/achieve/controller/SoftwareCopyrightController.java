package achieve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/softwareCopyright")
public class SoftwareCopyrightController {

    @RequestMapping("/index")
    public String index(){
        return "softwareCopyright/index";
    }

    @RequestMapping("/add")
    public String add(){
        return "softwareCopyright/add";
    }

    @RequestMapping("/show")
    public String show(){
        return "softwareCopyright/show";
    }

    @RequestMapping("/edit")
    public String edit(){
        return "softwareCopyright/edit";
    }

}
