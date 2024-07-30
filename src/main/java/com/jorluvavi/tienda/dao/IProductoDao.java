
package com.jorluvavi.tienda.dao;

import com.jorluvavi.tienda.model.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jorge
 */
public interface IProductoDao extends JpaRepository<Producto, Long>{
    
}
