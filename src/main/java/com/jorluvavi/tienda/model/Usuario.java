
package com.jorluvavi.tienda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author jorge
 */
@Data
@Entity
@Table(name = "usuario")
public class Usuario  implements Serializable{
    
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;
    
    private String username;
    
    private String password;
    
    @OneToMany
    @JoinColumn(name = "idUsuario")
    private List<Rol> roles;
}
