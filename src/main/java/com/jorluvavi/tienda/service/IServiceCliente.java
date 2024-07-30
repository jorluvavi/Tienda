
package com.jorluvavi.tienda.service;

import com.jorluvavi.tienda.model.Cliente;
import java.util.List;

/**
 *
 * @author jorge
 */

public interface IServiceCliente {
    
    
    public List<Cliente> listarClientes();
    
    public void guardarCliente(Cliente cliente);
    
    public void eliminarCliente(Cliente cliente);
    
    public Cliente encontrarCliente(Cliente cliente);
    
}