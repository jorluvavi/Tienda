/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jorluvavi.tienda.dao;

import com.jorluvavi.tienda.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jorge
 */
public interface IUsuarioDao extends JpaRepository<Usuario, Long>{
    Usuario findByUsername(String username);
}
