
package com.jorluvavi.tienda.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author jorge
 */
@Controller
@Slf4j
public class CajaController {
    
    @GetMapping("/caja")
    public String caja(Authentication auth, Model model){
        //Para el manejo de la autenticacion
        String username = auth.getName();
        String rol = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("ROLE_UNKNOWN");
        model.addAttribute("rol", rol);
        model.addAttribute("username", username);
        return "caja";
    }
}
