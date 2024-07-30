
package com.jorluvavi.tienda.dao;

import com.jorluvavi.tienda.model.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jorge
 */
public interface IClienteDao extends CrudRepository<Cliente, Long>{
    
}
