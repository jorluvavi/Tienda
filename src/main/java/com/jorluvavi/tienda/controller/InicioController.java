/*
Clase de Controlador de la página de Inicio
 */
package com.jorluvavi.tienda.controller;

import com.jorluvavi.tienda.service.ServiceCliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author jorge
 */
@Controller
@Slf4j
public class InicioController {

    @Autowired
    private ServiceCliente serviceCliente;

    @GetMapping("/")
    public String inicio(Authentication auth, Model model) {
        String username = auth.getName();
        String rol = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("ROLE_UNKNOWN");
        boolean isAuth = auth.isAuthenticated();

        model.addAttribute("rol", rol);
        model.addAttribute("username", username);
        model.addAttribute("isAuth", isAuth);
        return "index";
    }

}
