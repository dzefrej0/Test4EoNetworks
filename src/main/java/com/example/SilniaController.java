package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SilniaController {
    @RequestMapping("/")
String index(){
return "index";



}
    String olo = "loloo";
    @RequestMapping(value = "message", method = RequestMethod.GET)
    public String messages(Model model) {
        model.addAttribute("message", olo);
        return "message";
    }


}