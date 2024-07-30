package com.jorluvavi.tienda.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author jorge
 */
@Controller
@Slf4j
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return ("login");
    }

    @GetMapping("/403")
    public String pagina403() {
        return "403";
    }

    @GetMapping("/404")
    public String pagina404() {
        return "404";
    }

}
