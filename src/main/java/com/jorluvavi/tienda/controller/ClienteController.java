package com.jorluvavi.tienda.controller;

import com.jorluvavi.tienda.model.Cliente;
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
public class ClienteController {

    @Autowired
    private ServiceCliente serviceCliente;

    @GetMapping("/clientes")
    public String clientes(Model model, Authentication auth) {
        var clientes = serviceCliente.listarClientes();
        var saldoTotal = 0D;
   
        for (var p : clientes) {
            saldoTotal += p.getSaldo();
        }
        
        String username = auth.getName();
        String rol = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("ROLE_UNKNOWN");

        model.addAttribute("rol", rol);
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("clientes", clientes);
        model.addAttribute("totalClientes", clientes.size());
        model.addAttribute("username", username);
        return "clientes";
    }

    @GetMapping("/clientes/registrar")
    public String registrar(Cliente cliente, Model model, Authentication auth) {
        var clientes = serviceCliente.listarClientes();
        String username = auth.getName();
        String rol = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("ROLE_UNKNOWN");

        model.addAttribute("rol", rol);
        model.addAttribute("clientes", clientes);
        model.addAttribute("username", username);
        return "modificar";
    }

    //Método POST del formulario de guardar
    @PostMapping("/guardar")
    public String guardar(Cliente cliente) {
        serviceCliente.guardarCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String editar(Cliente cliente, Model model) {
        cliente = serviceCliente.encontrarCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Cliente cliente, Model model) {
        serviceCliente.eliminarCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "redirect:/clientes";
    }
}
