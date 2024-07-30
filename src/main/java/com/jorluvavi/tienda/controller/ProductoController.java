package com.jorluvavi.tienda.controller;

import com.jorluvavi.tienda.dao.IProductoDao;
import com.jorluvavi.tienda.model.Producto;
import com.jorluvavi.tienda.service.ServiceProducto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jorge
 */
@Controller
@Slf4j
public class ProductoController {

    @Autowired
    private ServiceProducto serviceProducto;

    @GetMapping("/productos")
    public String productos(@PageableDefault(size = 10, page = 0) Pageable pageable, Model model, Authentication auth) {
        
        Page<Producto> page = serviceProducto.listarProductosPage(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));
        model.addAttribute("page", page);

        var totalPages = page.getTotalPages();
        var currentPages = page.getNumber();

        var start = Math.max(1, currentPages);
        var end = Math.min(currentPages + 5, totalPages);

        if (totalPages > 0) {
            List<Integer> pageNumbers = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                pageNumbers.add(i);
            }
            model.addAttribute("pageNumbers", pageNumbers);
        }
        List<Integer> pageSizeOptions = Arrays.asList(10, 30, 50, 100);
        model.addAttribute("pageSizeOptions", pageSizeOptions);
        
        //Para el manejo de la autenticacion
        String username = auth.getName();
        String rol = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("ROLE_UNKNOWN");
        model.addAttribute("rol", rol);
        model.addAttribute("username", username);

        return "productos";
    }

}
