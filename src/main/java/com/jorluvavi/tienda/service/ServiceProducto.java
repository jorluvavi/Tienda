
package com.jorluvavi.tienda.service;

import com.jorluvavi.tienda.dao.IProductoDao;
import com.jorluvavi.tienda.model.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

/**
 *
 * @author jorge
 */

@Service
public class ServiceProducto implements IServiceProducto {

    @Autowired
    private IProductoDao productoDao;
    
    @Override
    public List<Producto> listarProductos() {
        return (List<Producto>) productoDao.findAll();
    }
    
    public Page<Producto> listarProductosPage(Pageable pageable){
        return (Page<Producto>) productoDao.findAll(pageable);
    }
    
    @Override
    public void registrarProducto(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    public void eliminarProducto(Producto producto) {
        productoDao.delete(producto);
    }

    @Override
    public Producto econtrarProducto(Producto producto) {
        return productoDao.findById(producto.getId()).orElse(null);
    }
    
}
