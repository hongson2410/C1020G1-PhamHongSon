package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    @GetMapping("")
    public String home(){
        return "/home";
    }

    @GetMapping("/dictionary")
    public String dictionary(@RequestParam String search, Model model) {
        Map<String, String> dic = new HashMap<>();
        dic.put("hello", "Xin chào");
        dic.put("how", "Thế nào");
        dic.put("book", "Quyển vở");
        dic.put("computer", "Máy tính");

        String result = dic.get(search);

        if (result != null) {
            model.addAttribute("msg"," ");
            model.addAttribute("search",search);
            model.addAttribute("result",result);
        } else {
            model.addAttribute("msg","Not Found!!");
        }

        return "/dictionary";
    }
}
