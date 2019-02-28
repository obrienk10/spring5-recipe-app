package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {


    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {

        return "index";
    }
}