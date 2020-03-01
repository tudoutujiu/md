package com.sdn.controller;

import com.sdn.service.fantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fanta")
public class fantaController {
    @Autowired
    fantaService biz;
    @RequestMapping("/list")
    public String getFanta(Model model){
        model.addAttribute("list",biz.getAll());
        return "fantaList";
    }
}
