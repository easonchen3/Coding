package com.baiguo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HP
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/index", "/index.jsp"})
    public String index() {
        return "new";
    }
}
