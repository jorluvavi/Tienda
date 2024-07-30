
package com.jorluvavi.tienda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author jorge
 */

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {
    
    private final static Long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private int stock;
    private double precio;
    private String categoria;
    private Date fecha;
    private String descripcion;
    
}
