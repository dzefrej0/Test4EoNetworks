package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class SilniaController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Post post) {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET)
public String printWelcome(ModelMap model) {
model.addAttribute("title", "Hello world!");
return "main";
}
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addNewPost(@Valid Post post, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        post.getMessage();
        post.setMessage("miskuzi");
        System.out.println(post.getMessage());
        model.addAttribute("title", post.getTitle());
        model.addAttribute("content", post.getContent());
        model.addAttribute("message", post.getMessage());
        return "result";
    }
}