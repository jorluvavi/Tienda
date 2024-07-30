
package com.jorluvavi.tienda.service;

import com.jorluvavi.tienda.model.Producto;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface IServiceProducto {
    
    public List<Producto> listarProductos();
    
    public void registrarProducto(Producto producto);
    
    public void eliminarProducto(Producto producto);
    
    public Producto econtrarProducto(Producto producto);
}
