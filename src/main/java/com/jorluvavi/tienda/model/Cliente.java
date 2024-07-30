
package com.jorluvavi.tienda.model;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
//import javax.valdation.constrains.NotEmpty;

/**
 *
 * @author jorge
 */
@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
    
    private final static long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private double saldo;
    
}
